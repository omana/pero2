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

import jp.co.omana.entity.MovieInfo;
import jp.co.omana.entity.MovieSeries;
import jp.co.omana.service.MovieInfoService;
import jp.co.omana.service.MovieSeriesService;

import org.seasar.framework.util.IntegerConversionUtil;
import org.seasar.framework.util.StringConversionUtil;
import org.seasar.struts.annotation.Execute;


import java.util.ArrayList;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.regex.Matcher;



public class AddAction {


	@Resource
	MovieInfoService movieInfoService;

	@Resource
	MovieSeriesService movieSeriesService;



	public List<MovieInfo> movieInfoList = new ArrayList<MovieInfo>();
	public List<MovieSeries> movieSerieList = new ArrayList<MovieSeries>();
	public List<MovieInfo> mMeaningMovieInfoList = new ArrayList<MovieInfo>();


	private String judgeUrl= new String();
	List<String> urls = new ArrayList<String>();
	private String[] splitUrl = new String[5];
	private String mMeaning;
	private int numIndex = 0;
	private String m_num=new String();
	private int sNum = 0;
	private int maxSid=0;
	private int maxSnum=0;
	private int patternMatchCount;
	private int patternSameSnumCount;


	private String integers ="[0-9]";
	private String romaOne ="_i_";
	private String romaMulti ="_i{2,}";
	private String movie3d="3d";
	private String mp4=".mp4";
	private String usDot="_|¥.|-";
	private String storyPre="¥_episode|¥_part|¥_pt";

	private Pattern integersPattern = Pattern.compile(integers);
	private Pattern romaOnePattern =Pattern.compile(romaOne);
	private Pattern romaMultiPattern = Pattern.compile(romaMulti);
	private Pattern threedPattern = Pattern.compile(movie3d);
	private Pattern mp4Pattern = Pattern.compile(mp4);
	private Pattern undrScrPattern = Pattern.compile(usDot);
	private Pattern storyPrePattern = Pattern.compile(storyPre);

	private Matcher matcherIntegers;
	private Matcher matcherRomeO;
	private Matcher matcherRomeM;
	private Matcher matcher3d;
	private Matcher matcherMp4;
	private Matcher matcherUsDot;
	private Matcher matcherStoryPre;

	private MatchResult matcherResult;




	@Execute(validator = false)
	public String index() {
		return "index.jsp";
	}

	/**
	 *@author ikraikra
	 * @return seriesAdd.jsp
	 */
	@Execute(validator=false)
	public String seriesAdd(){

		movieInfoList=movieInfoService.findAllOrderByIdNotDeleted();
		System.out.println("-----------------------"+movieInfoList.size());
		/**
		 * movieInfoから情報を取得する。
		 */
		for (MovieInfo mIL:movieInfoList){
			m_num = null;
			judgeUrl = mIL.detailUrl;
			splitUrl = judgeUrl.split("/"); //URLを/で分割する。

			//http://www.xvideos.com/video2713394/hogehogeのうちhogehoge部分のみ抽出
			mMeaning = splitUrl[4];

			/**
			 * mp4と3dがあれば削除する。
			 */
			//.mp４があれば""で置き換える。
			matcherMp4 = mp4Pattern.matcher(mMeaning);
			mMeaning=matcherMp4.replaceAll("");

			//3dがあれば""で置き換える。
			matcher3d = threedPattern.matcher(mMeaning);
			mMeaning = matcher3d.replaceAll("");

			/**
			 * snum用のm_numの取得を行う。
			 */
			//mMeaningの中に0-9の数字がないかチェック
			matcherIntegers = integersPattern.matcher(mMeaning);

			//			//mMeaningの中に1-9の数字がないかチェック
			//			matcherNum =numberPattern.matcher(mMeaning);

			//mMeaning中にローマ数字による番号があるかチェック
			matcherRomeO=romaOnePattern.matcher(mMeaning); //_iの場合
			matcherRomeM=romaMultiPattern.matcher(mMeaning); //i_の場合

			//mMeaning中に0-9を含んでいた場合
			if (matcherIntegers.find()) {
				numIndex = matcherIntegers.end();

				//数字のある限りループする。
				while(matcherIntegers.find()){

					matcherResult = matcherIntegers.toMatchResult();
					numIndex = matcherResult.end();

				}

				//m_numを一桁の数字として取得する。
				m_num = mMeaning.substring(numIndex-1,numIndex);

				//m_numの番号以後の文字は消す
				mMeaning = mMeaning.substring(0,numIndex-1);

				//m_numが0の場合は10とする。
				if (m_num.equals("0")){
					m_num ="10";
					mMeaning = mMeaning.substring(0,numIndex-2);
				}

				//_i_があった場合
			} else if (matcherRomeO.find()){
				m_num = "1";

				//_i_を""で置き換える。
				mMeaning = matcherRomeO.replaceAll("");

				//_i{2,}があった場合
			} else if(matcherRomeM.find()){
				m_num = matcherRomeM.group();

				//_i{2,}を""で置き換える。
				mMeaning = matcherRomeM.replaceAll("");

			}


			/**
			 * mMeaningの整形を行う。
			 */
			//mMeaning中に"_episode,_part,_pt"がないかチェック
			matcherStoryPre = storyPrePattern.matcher(mMeaning);

			//"_episode,_part,_pt"を""で置き換える。
			while (matcherStoryPre.find()){
				System.out.println(mMeaning);
				mMeaning = matcherStoryPre.replaceAll("");
				System.out.println(mMeaning);
			}

			//mMeaning中に"_"がないかチェック
			matcherUsDot=undrScrPattern.matcher(mMeaning);

			//"_"を""で置き換える。
			while (matcherUsDot.find()) {
				mMeaning=matcherUsDot.replaceAll("");
			}


			/**
			 * 一意のSIDの探索を行う。
			 */
			//movieInfoのtemp1にmMeaningを挿入しテーブルをアップデートする。
			mIL.temp1=mMeaning;
			movieInfoService.update(mIL);

			//MovieSeriesのテーブルからmIL.temp1が共通なもの数えます。
			patternMatchCount = movieSeriesService.getPatternCount(mIL.temp1);

			/**
			 * movieSeriesに項目を詰める。
			 */
			MovieSeries movieSeries=new MovieSeries();
			//m_numが0であった場合
			if (m_num == null) {
				movieSeries.snum=1;

				//＿iiの場合
			} else if (m_num.equals("_ii")) {
				movieSeries.snum=2;

				//_iiiの場合
			} else if (m_num.equals("_iii")) {
				movieSeries.snum=3;

			} else {
				//m_numをintに変換する。
				sNum =IntegerConversionUtil.toInteger(m_num);
				movieSeries.snum=sNum;
			}

			//patternが共通のものが存在しない場合
			if (patternMatchCount == 0) {

				//sidの最大値を取得する。
				maxSid = movieSeriesService.getMaxSid();
				movieSeries.sid = maxSid + 1;
				System.out.println("最大値:---------------" + maxSid + ":" + movieSeries.sid  );

				//snumを1とする。
				movieSeries.snum=1;

				//同じpatternが存在する場合
			}else  if (patternMatchCount != 0) {

				//同じpatternのSidを取得する。
				movieSeries.sid = movieSeriesService.findSidOnMatcheVideo(mIL.temp1);
				System.out.println("同じもの"+ movieSeries.sid +" : " + movieSeries.snum);
				//同じpatternかつ、同じsnumが存在しないか確認する。
				patternSameSnumCount= movieSeriesService.findSameSnum(mIL.temp1,movieSeries.sid, movieSeries.snum);

				//同じpatternかつ、同じsnumが存在する場合
				if (patternSameSnumCount != 0) {
					System.out.println(movieSeries.snum);

					//同じsidのものの中で、snumの最大値 +1 を取得する。
					maxSnum = movieSeriesService.findMaxSnumBySamePattern(movieSeries.sid);
					System.out.println("maxSnum:" + maxSnum);
					movieSeries.snum = 1 + maxSnum;
				}

			}

			movieSeries.mid = mIL.mid;
			movieSeries.stitle = mIL.mtitle;
			movieSeries.spic = mIL.mpic;
			movieSeries.stime = IntegerConversionUtil.toInteger(mIL.mtime);
			movieSeries.sdate = mIL.mdate;
			movieSeries.SDeadFlg = mIL.deadFlg;
			movieSeries.compFlg = 0;
			movieSeries.role = StringConversionUtil
					.toString(movieSeries.sid % 3);//0：あやや、1:おのぎ、2:なかい
			movieSeries.totalPlay = 0;
			movieSeries.pattern1 = mIL.temp1;

			int countInsert = movieSeriesService.insert(movieSeries);
			System.out.println(countInsert);

			mIL.editFlg = 1;
			movieInfoService.update(mIL);

		}

		return "add.jsp";
	}
}