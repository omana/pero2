/*
 * Copyright 2004-2008 the Seasar Foundation and the Others.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package jp.co.omana.action;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.omana.dto.MovieListDto;
import jp.co.omana.entity.MasterCat;
import jp.co.omana.entity.MovieSeries;
import jp.co.omana.form.IndexForm;
import jp.co.omana.service.MasterCatService;
import jp.co.omana.service.MovieSeriesService;

import org.seasar.framework.util.IntegerConversionUtil;
import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;
import org.seasar.struts.util.RequestUtil;
import org.seasar.struts.util.ResponseUtil;




import java.util.ArrayList;
import java.util.List;



public class IndexAction{


	@Resource
	MovieSeriesService movieSeriesService;

	@Resource
	MasterCatService masterCatService;

	@ActionForm
	@Resource
	IndexForm indexForm = new IndexForm();

	@Resource
	protected MovieListDto movieListDto;


	private static final int LIMIT = 9;

	//前のページがあるかどうか
	public boolean hasPrev = false;

	//次のページがあるかどうか
	public boolean hasNext = false;

	//Snumが1であるものの件数
	public long total;

	public int catId=0;
	public int page=1;
	public int maxPage = 0;

	public int sid = 0;

	public String catName = "";
	public String movieName = "";

	public List<Integer> pagingList = new ArrayList<Integer>();
	public List<MovieSeries> movieSeriesList = new ArrayList<MovieSeries>();
	public List<MovieSeries> movieSeriesSidList = new ArrayList<MovieSeries>();
	public List<MovieSeries> despMovieSeriesList = new ArrayList<MovieSeries>();
	public List<MasterCat> masterCatList = new ArrayList<MasterCat>();

	//履歴を入れるリスト
	public List<MovieSeries> hisList = new ArrayList<MovieSeries>();

	Paging paging = new Paging() {
	};

	@Execute(validator = false)
	public String index(){
		page = 1;
		catId = 0;
		masterCatList = masterCatService.findAll();
		movieSeriesList = movieSeriesService.findMovieSeriesByCondition(catId, null, LIMIT, page);

		//snumが1であるものの件数を取得します。
		total = movieSeriesService.countMovieSeriesByCondition(catId, null);

		//前のページがあるかどうかを判定
		hasPrev = paging.hasPrevPage(page, LIMIT, total);

		//次のページがあるかどうかを判定
		hasNext = paging.hasNextPage(page, LIMIT, total);

		//表示するページングページを取得します。
		pagingList = paging.paging(page, LIMIT, total);

		//最大ページ数を取得します。
		maxPage = 1 + IntegerConversionUtil.toPrimitiveInt(total)/LIMIT;

		return "index.jsp";
	}

	/**
	 *動画を一覧表示します。
	 * @author iKra
	 * @return
	 */
	@Execute(validator = true, input = "index.jsp", urlPattern = "search/{catId}/{page}")
	public String search(){

		//indexFormのcatIdがnullでない場合
		if(!indexForm.catId.equals("")){
			catId = IntegerConversionUtil.toPrimitiveInt(indexForm.catId);
			movieListDto.catId = catId;
		}
		//カテゴリーIDに準じたカテゴリー名を取得します。
		try {
			catName = masterCatService.findById(movieListDto.catId).catName;

			//カテゴリがない場合はcatNameにジャンル未選択を入れます。
		} catch (NullPointerException e) {
			catName = "ジャンル未選択";
		}

		//ページ番号を取得します。
		page = IntegerConversionUtil.toPrimitiveInt(indexForm.page);

		//pageが0あるいは、指定されていない場合
		if(page == 0){
			page = 1;
		}

		//snumが1であるものの件数を取得します。
		total = movieSeriesService.countMovieSeriesByCondition(movieListDto.catId, null);

		//role,カテゴリー, sNumが1のものをMovieSeriesから検索します。
		movieSeriesList = movieSeriesService.findMovieSeriesByCondition(movieListDto.catId, null, LIMIT, page);

		Paging paging = new Paging() {		};

		//前のページがあるかどうかを判定
		hasPrev = paging.hasPrevPage(page, LIMIT, total);

		//次のページがあるかどうかを判定
		hasNext = paging.hasNextPage(page, LIMIT, total);

		//表示するページングページを取得します。
		pagingList = paging.paging(page, LIMIT, total);

		//最大ページ数を取得します。
		maxPage = 1 + IntegerConversionUtil.toPrimitiveInt(total)/LIMIT;

		//カテゴリー名を取得します。
		masterCatList = masterCatService.findAll();


		//クッキーから履歴を取得します。
		HttpServletRequest req = RequestUtil.getRequest();

		//クッキーを取得します。
		Cookie[] cookies = req.getCookies();

		//クッキーがnullでない場合
		if (!cookies.equals("")){
			for (int i=0;i<cookies.length;i++){

				//cookieの識別子がmovieIdの場合
				if(cookies[i].getName().startsWith("movieId")){
					System.out.println("----------------------koko----------" + cookies[i].getValue());
					Integer movieId = IntegerConversionUtil.toInteger(cookies[i].getValue());

					//クッキーのValueがnullあるいは、0の場合
					if(movieId == 0){
						continue;
					}

					System.out.println("---------------------------------"+movieId);
					hisList.add(movieSeriesService.findById(movieId, 1));
				}
			}
		}

		for(MovieSeries hLt:hisList){
			System.out.println("------------------ここは？-----"+hLt.stitle);
		}

		return "index.jsp";
	}

	/**
	 * 動画の詳細を表示します。
	 * @author iKra
	 * @return
	 */
	@Execute(validator = true, input = "index.jsp", urlPattern ="detail/{sid}")
	public String detail(){

		//取得したsidをintに変えます。
		int sid = IntegerConversionUtil.toPrimitiveInt(indexForm.sid);

		//取得したsidで動画を検索します。
		movieSeriesList = movieSeriesService.findBySId(sid);

		//動画のタイトルを取得します。
		try {
			movieName = movieSeriesList.get(0).stitle;
		} catch (NullPointerException e) {
			movieName = "タイトルがありません。";
		}

		//表示したビデオの再生回数を+1します。
		for(MovieSeries mSL:movieSeriesList ){
			mSL.totalPlay += 1;
			movieSeriesService.update(mSL);
		}


		HttpServletResponse res = ResponseUtil.getResponse();

		//クッキー再生動画のsidをクッキーに入れます。
		Cookie cookie = new Cookie("movieId", indexForm.sid);
		cookie.setPath("/");
		cookie.setMaxAge(3600*24*30);
		res.addCookie(cookie);

		//表示用のカテゴリーのマスターを取得します。
		masterCatList = masterCatService.findAll();
		return "detail.jsp";

	}

}