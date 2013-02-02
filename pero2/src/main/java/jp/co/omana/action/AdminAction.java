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

import jp.co.omana.dto.LoginDto;
import jp.co.omana.dto.MovieListDto;
import jp.co.omana.entity.MasterCat;
import jp.co.omana.entity.MovieSeries;
import jp.co.omana.form.AdminForm;
import jp.co.omana.service.MasterCatService;
import jp.co.omana.service.MovieInfoService;
import jp.co.omana.service.MovieSeriesService;

import org.seasar.framework.aop.annotation.RemoveSession;
import org.seasar.framework.util.IntegerConversionUtil;
import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;



import java.util.ArrayList;
import java.util.List;



public class AdminAction{


	@Resource
	MovieInfoService movieInfoService;

	@Resource
	MovieSeriesService movieSeriesService;

	@Resource
	MasterCatService masterCatService;

	@ActionForm
	@Resource
	AdminForm adminForm = new AdminForm();

	@Resource
	protected LoginDto loginDto;

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
	public String role = "0";

	public int sid = 0;

	public String catName = "";

	public List<Integer> pagingList = new ArrayList<Integer>();
	public List<MovieSeries> movieSeriesList = new ArrayList<MovieSeries>();
	public List<MovieSeries> movieSeriesSidList = new ArrayList<MovieSeries>();
	public List<MovieSeries> despMovieSeriesList = new ArrayList<MovieSeries>();
	public List<MasterCat> masterCatList = new ArrayList<MasterCat>();


	@Execute(validator = false)
	public String index()  {
		return "admin_login.jsp";
	}

	/**
	 * ログイン画面を表示します。
	 * @author iKra
	 * @return
	 */
	@Execute(validator = true, input = "admin_login.jsp")
	public String loginUsr(){
		System.out.println("--ログインするよーここだよー----------------------------"+loginDto.userName);
		//ログインできる場合
		if((adminForm.userName.equals("omana") && adminForm.password.equals("123456a-"))
				|| (loginDto.userName !=null && loginDto.userName.equals("omana"))){


			loginDto.userName = "omana";
			movieListDto.catId = 0;

			return adminTop();
		} else {
			return "admin_login.jsp";
		}
	}


	/**
	 * 動画一覧を表示します。
	 * @author iKra
	 * @return
	 */
	@Execute(validator = false,urlPattern = "movieList/{catId}/{page}")
	public String adminTop(){



		System.out.println("------------------1--------adminForm.roles  "+ adminForm.roles+ " loginDto.roleId "+loginDto.roleId);
		//adminFormのrolesがnullでない場合
		if (!adminForm.roles.equals("")) {
			System.out.println("--------------if----1--------adminForm.roles  "+ adminForm.roles+ " loginDto.roleId "+loginDto.roleId);

			//adminForm.rolesとloginDto.roleIdが異なる場合
			if (!adminForm.roles.equals(loginDto.roleId)) {
				loginDto.roleId = adminForm.roles;
			}

		}

		System.out.println("------------------２--------adminForm.roles  "+ adminForm.roles+ " loginDto.roleId "+loginDto.roleId +" movie_Cat "+movieListDto.catId);

		//adminFormのcatIdがnullでない場合
		if(!adminForm.catId.equals("")){
			catId = IntegerConversionUtil.toPrimitiveInt(adminForm.catId);
			movieListDto.catId = catId;
		}

		//ページ番号を取得します。
		page =IntegerConversionUtil.toPrimitiveInt(adminForm.page);

		//pageが0あるいは、指定されていない場合
		if(page == 0){
			page = 1;
		}

		//snumが1であるものの件数を取得します。
		total = movieSeriesService.countMovieSeriesByCondition(movieListDto.catId, loginDto.roleId);

		System.out.println("------------------3--------adminForm.roles  "+ adminForm.roles+ " loginDto.roleId "+loginDto.roleId +" movie_Cat "+movieListDto.catId);

		//role,カテゴリー, sNumが1のものをMovieSeriesから検索します。
		movieSeriesList = movieSeriesService.findMovieSeriesByCondition(movieListDto.catId, loginDto.roleId, LIMIT, page);
		role = loginDto.roleId;

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

		//カテゴリーIDに準じたカテゴリー名を取得します。
		try {
			catName = masterCatService.findById(movieListDto.catId).catName;

			//カテゴリがない場合はcatNameにジャンル未選択を入れます。
		} catch (NullPointerException e) {
			catName = "ジャンル未選択";
		}

		return "admin_top.jsp";
	}

	/**
	 * 動画を編集します。
	 * @return
	 */
	@Execute(validator = true, input = "admin_login.jsp", urlPattern ="edit_movie/{sid}")
	public String movieEdit(){

		//sidが0でない場合sessionに詰める。
		if (adminForm.sid != null) {
			movieListDto.sid = IntegerConversionUtil.toPrimitiveInt(adminForm.sid);
		}

		System.out.println("--------------------"+adminForm.sid);
		int sid = movieListDto.sid;
		System.out.println("--------------------------------"+sid);
		movieSeriesList = movieSeriesService.findBySId(sid);
		masterCatList = masterCatService.findAll();
		return "admin_detail.jsp";
	}

	/**
	 * 動画をアップデートします。
	 * @return
	 */
	@Execute(validator = false, urlPattern ="update_movie/{mid}")
	public String update_movie(){
		MovieSeries movieS = new MovieSeries();

		//sIdを別のものにするときは、最大値を取得します。
		if (adminForm.sid == null) {
			movieS.sid = 1 + movieSeriesService.getMaxSid();
		}

		movieSeriesService.update(movieS);
		return movieEdit();
	}

	/**
	 * ログアウトします。
	 * @return
	 */
	@Execute(validator = false)
	@RemoveSession(name = "loginDto")
	public String logout() {
		return "admin_login.jsp";
	}

	/**
	 * 管理画面でdeleteFlgが1ものを削除します。
	 * @return
	 */
	@Execute(validator = false)
	public String delete(){
		int deleteRaws =0;
		deleteRaws =movieSeriesService
				.deleteBydeleteFlg();
		System.out.println("deleteRaws------------------------"+deleteRaws);

		return adminTop();
	}

}