package jp.co.omana.entity;

import javax.annotation.Generated;
import org.seasar.extension.jdbc.JdbcManager;
import org.seasar.extension.unit.S2TestCase;

import static jp.co.omana.entity.MasterCatNames.*;

/**
 * {@link MasterCat}のテストクラスです。
 * 
 */
@Generated(value = {"S2JDBC-Gen 2.4.45", "org.seasar.extension.jdbc.gen.internal.model.EntityTestModelFactoryImpl"}, date = "2013/02/03 5:37:18")
public class MasterCatTest extends S2TestCase {

    private JdbcManager jdbcManager;

    /**
     * 事前処理をします。
     * 
     * @throws Exception
     */
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        include("s2jdbc.dicon");
    }

    /**
     * 識別子による取得をテストします。
     * 
     * @throws Exception
     */
    public void testFindById() throws Exception {
        jdbcManager.from(MasterCat.class).id(1).getSingleResult();
    }

    /**
     * movieCatListとの外部結合をテストします。
     * 
     * @throws Exception
     */
    public void testLeftOuterJoin_movieCatList() throws Exception {
        jdbcManager.from(MasterCat.class).leftOuterJoin(movieCatList()).id(1).getSingleResult();
    }
}