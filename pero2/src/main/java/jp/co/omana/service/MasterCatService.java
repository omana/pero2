package jp.co.omana.service;

import java.util.List;
import javax.annotation.Generated;
import jp.co.omana.entity.MasterCat;

import static jp.co.omana.entity.MasterCatNames.*;
import static org.seasar.extension.jdbc.operation.Operations.*;

/**
 * {@link MasterCat}のサービスクラスです。
 *
 */
@Generated(value = {"S2JDBC-Gen 2.4.45", "org.seasar.extension.jdbc.gen.internal.model.ServiceModelFactoryImpl"}, date = "2012/09/30 19:14:34")
public class MasterCatService extends AbstractService<MasterCat> {

    /**
     * 識別子でエンティティを検索します。
     *
     * @param catid
     *            識別子
     * @return エンティティ
     */
    public MasterCat findById(Integer catid) {
        return select().id(catid).getSingleResult();
    }

    /**
     * 識別子の昇順ですべてのエンティティを検索します。
     *
     * @return エンティティのリスト
     */
    public List<MasterCat> findAllOrderById() {
        return select().orderBy(asc(catid())).getResultList();
    }
}