package jp.co.omana.service;

import java.util.List;
import javax.annotation.Generated;

import org.seasar.extension.jdbc.where.SimpleWhere;

import jp.co.omana.entity.MovieInfo;

import static jp.co.omana.entity.MovieInfoNames.*;
import static org.seasar.extension.jdbc.operation.Operations.*;

/**
 * {@link MovieInfo}のサービスクラスです。
 *
 */
@Generated(value = {"S2JDBC-Gen 2.4.45", "org.seasar.extension.jdbc.gen.internal.model.ServiceModelFactoryImpl"}, date = "2012/09/30 19:14:34")
public class MovieInfoService extends AbstractService<MovieInfo> {

	/**
	 * 識別子でエンティティを検索します。
	 *
	 * @param mid
	 *            識別子
	 * @return エンティティ
	 */
	public MovieInfo findById(Integer mid) {
		return select().id(mid).getSingleResult();
	}

	/**
	 * 識別子の昇順ですべてのエンティティを検索します。
	 *
	 * @return エンティティのリスト
	 */
	public List<MovieInfo> findAllOrderById() {
		return select().orderBy(desc(mid())).getResultList();
	}

	/**
	 * delete_flgが0で、temp4が1でないものを識別子の昇順ですべてのエンティティを検索します。
	 *@author ikraikra
	 * @return エンティティのリスト
	 */
	public List<MovieInfo> findAllOrderByIdNotDeleted() {
		SimpleWhere ntDeadNEdt = new SimpleWhere()
		.ne("deadFlg", 1)
		.eq("editFlg", 0);
		return select()
				.orderBy(desc(mid()))
				.where(ntDeadNEdt)
				.getResultList();
	}

}