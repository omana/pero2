package jp.co.omana.service;

import java.util.List;
import javax.annotation.Generated;
import jp.co.omana.entity.MovieCatXvideo;

import static jp.co.omana.entity.MovieCatXvideoNames.*;
import static org.seasar.extension.jdbc.operation.Operations.*;

/**
 * {@link MovieCatXvideo}のサービスクラスです。
 * 
 */
@Generated(value = {"S2JDBC-Gen 2.4.45", "org.seasar.extension.jdbc.gen.internal.model.ServiceModelFactoryImpl"}, date = "2012/09/30 19:14:34")
public class MovieCatXvideoService extends AbstractService<MovieCatXvideo> {

    /**
     * 識別子でエンティティを検索します。
     * 
     * @param movieInfoMid
     *            識別子
     * @param tag
     *            識別子
     * @return エンティティ
     */
    public MovieCatXvideo findById(Integer movieInfoMid, String tag) {
        return select().id(movieInfoMid, tag).getSingleResult();
    }

    /**
     * 識別子の昇順ですべてのエンティティを検索します。
     * 
     * @return エンティティのリスト
     */
    public List<MovieCatXvideo> findAllOrderById() {
        return select().orderBy(asc(movieInfoMid()), asc(tag())).getResultList();
    }
}