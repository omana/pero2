package jp.co.omana.service;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

import org.seasar.extension.jdbc.where.SimpleWhere;

import jp.co.omana.entity.MovieSeries;

import static jp.co.omana.entity.MovieSeriesNames.*;
import static org.seasar.extension.jdbc.operation.Operations.*;

/**
 * {@link MovieSeries}のサービスクラスです。
 *
 */
@Generated(value = {"S2JDBC-Gen 2.4.45", "org.seasar.extension.jdbc.gen.internal.model.ServiceModelFactoryImpl"}, date = "2012/09/30 19:14:34")
public class MovieSeriesService extends AbstractService<MovieSeries> {

	//カテゴリの数の長さの配列。SimpleWhere用に作成
	private static final Integer condCatId[] = {null,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19};


	/**
	 * 識別子でエンティティを検索します。
	 *
	 * @param sid
	 * @param snum
	 * @return エンティティ
	 */
	public MovieSeries findById(Integer sid, Integer snum) {
		return select()
				.id(sid, snum)
				.getSingleResult();
	}

	/**
	 * 識別子の昇順ですべてのエンティティを検索します。
	 *
	 * @return エンティティのリスト
	 */
	public List<MovieSeries> findAllOrderById() {
		return select()
				.orderBy(asc(sid()), asc(snum()))
				.getResultList();
	}

	/**
	 * sidのMax値を取得します。
	 * @author iKra
	 */
	public int getMaxSid() {
		int maxSid = 0;
		MovieSeries movieSeries = new MovieSeries();

		try {
			movieSeries = select()
					.orderBy(desc(sid()))
					.limit(1)
					.getSingleResult();
			maxSid = movieSeries.sid;
		} catch (Exception e) {
			maxSid=0;
		}
		return maxSid;
	}

	/**
	 *
	 *デリートフラグが1でなく、patternが共通のものの個数を数えます。
	 *
	 * @author iKra
	 * @param pattern
	 * @return
	 */
	public int getPatternCount(String pattern){
		int patternCount = 0;

		patternCount = (int) select()
				.where(
						new SimpleWhere()
						.eq("pattern1",pattern)
						.eq("SDeadFlg", 0)
						)
						.getCount();

		return patternCount;
	}

	/**
	 *patternが共通でデリートフラグが0のもののsidを検索する。
	 *
	 * @param pattern
	 * @return
	 */
	public int findSidOnMatcheVideo(String pattern) {
		int sid=0;
		MovieSeries movieSeries = select()
				.where(
						new SimpleWhere()
						.eq("pattern1", pattern)
						.eq("SDeadFlg", 0)
						)
						.limit(1)
						.getSingleResult();
		sid=movieSeries.sid;

		return sid;
	}

	/**
	 *同じsId,sNum,patternを検索します。
	 * @param pattern
	 * @param sNum
	 * @return
	 */
	public int  findSameSnum(String pattern, int sid, int sNum) {
		int sameSnumCount =0;
		sameSnumCount = (int)select()
				.where(
						new SimpleWhere()
						.eq("pattern1", pattern)
						.eq("sid", sid)
						.eq("snum", sNum)
						)
						.getCount();

		return sameSnumCount;
	}

	/**
	 *同じパターンの中でSnumの最大値を取得します。
	 * @param id
	 * @return
	 */
	public int findMaxSnumBySamePattern(int id) {
		int maxSnum = 0;
		MovieSeries movieSeries =new MovieSeries();
		movieSeries = select()
				.orderBy(desc(snum()))
				.where(
						eqSId(id)
						)
						.limit(1)
						.getSingleResult();
		maxSnum = movieSeries.snum;

		return maxSnum;
	}


	/**
	 * catIdとroleId、sNumが1で全文を検索します。catIdが０の場合、検索条件から除外します。
	 * @param catId
	 * @param roleId
	 * @return
	 */
	public List<MovieSeries> findMovieSeriesByCondition(int catId, String roleId, int LIMIT, int page) {
		List<MovieSeries> movieList =new ArrayList<MovieSeries>();

		//pageを1ページ始まりにする。
		if(page > 0){
			page = page - 1;
		}

		//sNumが1かつ, カテゴリーがcatIdかつ、roleがroleIdの条件
		SimpleWhere condition =new SimpleWhere()
		.eq("snum", 1)
		.eq("compFlg", 0)
		.eq("movieInfo.movieCatList.masterCatCatid", condCatId[catId])
		.eq("role", roleId);

		movieList =select()
				.where(condition)
				.leftOuterJoin("movieInfo")
				.leftOuterJoin("movieInfo.movieCatList")
				.limit(LIMIT)
				.offset(LIMIT * page)
				.orderBy(asc(mid()))
				.getResultList();

		return movieList;
	}


	/**
	 * catIdとroleId、sNumが1の条件で件数を数えます。catIdが０の場合、検索条件から除外します。
	 * @param catId
	 * @param roleId
	 * @param LIMIT
	 * @param page
	 * @return
	 */
	public long countMovieSeriesByCondition(int catId, String roleId) {
		long count = 0;

		//sNumが1かつ, カテゴリーがcatIdかつ、roleがroleIdの条件
		SimpleWhere condition =new SimpleWhere()
		.eq("snum", 1)
		.eq("movieInfo.movieCatList.masterCatCatid", condCatId[catId])
		.eq("role", roleId);


		count =select()
				.where(condition)
				.leftOuterJoin("movieInfo")
				.leftOuterJoin("movieInfo.movieCatList")
				.getCount();

		return count;
	}




	/**
	 * sidで全文検索します。
	 * @param sId
	 * @return
	 */
	public List<MovieSeries> findBySId(int sId) {
		List<MovieSeries> movieSeriesList = new ArrayList<MovieSeries>();

		movieSeriesList = select()
				.where(eqSId(sId))
				.getResultList();

		return movieSeriesList;
	}

	/**
	 * midで動画を検索します。
	 * @param mid
	 * @return　MovieSeriesのエンティティ
	 */
	public MovieSeries findByMid(int mid) {
		MovieSeries movieSeries = new MovieSeries();
		SimpleWhere eqMid = new SimpleWhere()
		.eq("mid", mid);

		movieSeries = select()
				.where(eqMid)
				.getSingleResult();

		return movieSeries;
	}



	/**
	 * sidが一致する条件
	 * @param id
	 * @return SimpelWhere
	 */
	private SimpleWhere eqSId(int id) {
		SimpleWhere eqId = new SimpleWhere()
		.eq("sid",id);
		return eqId;
	}

	/**
	 * deleteFlgが１のものを削除します。
	 * @return
	 */
	public int deleteBydeleteFlg() {

		SimpleWhere deleteCon = new SimpleWhere()
		.eq("sDeadFlg", 1);

		int deleteRaws = 0;
		//deleteFlgが1のものが1のものを削除します。
		List<MovieSeries> movieSeriesList = new ArrayList<MovieSeries>();
		movieSeriesList = select()
				.where(deleteCon)
				.getResultList();

		for (MovieSeries mSL:movieSeriesList){
			deleteRaws = delete(mSL);
		}

		return deleteRaws;
	}

}