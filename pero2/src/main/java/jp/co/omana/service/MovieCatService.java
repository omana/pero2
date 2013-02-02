package jp.co.omana.service;

import java.util.List;
import javax.annotation.Generated;
import jp.co.omana.entity.MovieCat;

import static jp.co.omana.entity.MovieCatNames.*;
import static org.seasar.extension.jdbc.operation.Operations.*;

/**
 * {@link MovieCat}のサービスクラスです。
 * 
 */
@Generated(value = {"S2JDBC-Gen 2.4.45", "org.seasar.extension.jdbc.gen.internal.model.ServiceModelFactoryImpl"}, date = "2012/09/30 19:14:34")
public class MovieCatService extends AbstractService<MovieCat> {

    /**
     * 識別子でエンティティを検索します。
     * 
     * @param movieInfoMid
     *            識別子
     * @param masterCatCatid
     *            識別子
     * @return エンティティ
     */
    public MovieCat findById(Integer movieInfoMid, Integer masterCatCatid) {
        return select().id(movieInfoMid, masterCatCatid).getSingleResult();
    }

    /**
     * 識別子の昇順ですべてのエンティティを検索します。
     * 
     * @return エンティティのリスト
     */
    public List<MovieCat> findAllOrderById() {
        return select().orderBy(asc(movieInfoMid()), asc(masterCatCatid())).getResultList();
    }
}