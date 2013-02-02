package jp.co.omana.entity;

import java.sql.Date;
import javax.annotation.Generated;
import jp.co.omana.entity.MovieInfoNames._MovieInfoNames;
import org.seasar.extension.jdbc.name.PropertyName;

/**
 * {@link MovieSeries}のプロパティ名の集合です。
 * 
 */
@Generated(value = {"S2JDBC-Gen 2.4.45", "org.seasar.extension.jdbc.gen.internal.model.NamesModelFactoryImpl"}, date = "2013/02/03 5:37:14")
public class MovieSeriesNames {

    /**
     * sidのプロパティ名を返します。
     * 
     * @return sidのプロパティ名
     */
    public static PropertyName<Integer> sid() {
        return new PropertyName<Integer>("sid");
    }

    /**
     * snumのプロパティ名を返します。
     * 
     * @return snumのプロパティ名
     */
    public static PropertyName<Integer> snum() {
        return new PropertyName<Integer>("snum");
    }

    /**
     * midのプロパティ名を返します。
     * 
     * @return midのプロパティ名
     */
    public static PropertyName<Integer> mid() {
        return new PropertyName<Integer>("mid");
    }

    /**
     * stitleのプロパティ名を返します。
     * 
     * @return stitleのプロパティ名
     */
    public static PropertyName<String> stitle() {
        return new PropertyName<String>("stitle");
    }

    /**
     * spicのプロパティ名を返します。
     * 
     * @return spicのプロパティ名
     */
    public static PropertyName<String> spic() {
        return new PropertyName<String>("spic");
    }

    /**
     * stimeのプロパティ名を返します。
     * 
     * @return stimeのプロパティ名
     */
    public static PropertyName<Integer> stime() {
        return new PropertyName<Integer>("stime");
    }

    /**
     * sdateのプロパティ名を返します。
     * 
     * @return sdateのプロパティ名
     */
    public static PropertyName<Date> sdate() {
        return new PropertyName<Date>("sdate");
    }

    /**
     * SDeadFlgのプロパティ名を返します。
     * 
     * @return SDeadFlgのプロパティ名
     */
    public static PropertyName<Byte> SDeadFlg() {
        return new PropertyName<Byte>("SDeadFlg");
    }

    /**
     * compFlgのプロパティ名を返します。
     * 
     * @return compFlgのプロパティ名
     */
    public static PropertyName<Byte> compFlg() {
        return new PropertyName<Byte>("compFlg");
    }

    /**
     * roleのプロパティ名を返します。
     * 
     * @return roleのプロパティ名
     */
    public static PropertyName<String> role() {
        return new PropertyName<String>("role");
    }

    /**
     * totalPlayのプロパティ名を返します。
     * 
     * @return totalPlayのプロパティ名
     */
    public static PropertyName<Integer> totalPlay() {
        return new PropertyName<Integer>("totalPlay");
    }

    /**
     * pattern1のプロパティ名を返します。
     * 
     * @return pattern1のプロパティ名
     */
    public static PropertyName<String> pattern1() {
        return new PropertyName<String>("pattern1");
    }

    /**
     * temp1のプロパティ名を返します。
     * 
     * @return temp1のプロパティ名
     */
    public static PropertyName<Integer> temp1() {
        return new PropertyName<Integer>("temp1");
    }

    /**
     * temp2のプロパティ名を返します。
     * 
     * @return temp2のプロパティ名
     */
    public static PropertyName<String> temp2() {
        return new PropertyName<String>("temp2");
    }

    /**
     * temp3のプロパティ名を返します。
     * 
     * @return temp3のプロパティ名
     */
    public static PropertyName<Integer> temp3() {
        return new PropertyName<Integer>("temp3");
    }

    /**
     * temp4のプロパティ名を返します。
     * 
     * @return temp4のプロパティ名
     */
    public static PropertyName<String> temp4() {
        return new PropertyName<String>("temp4");
    }

    /**
     * movieInfoのプロパティ名を返します。
     * 
     * @return movieInfoのプロパティ名
     */
    public static _MovieInfoNames movieInfo() {
        return new _MovieInfoNames("movieInfo");
    }

    /**
     * @author S2JDBC-Gen
     */
    public static class _MovieSeriesNames extends PropertyName<MovieSeries> {

        /**
         * インスタンスを構築します。
         */
        public _MovieSeriesNames() {
        }

        /**
         * インスタンスを構築します。
         * 
         * @param name
         *            名前
         */
        public _MovieSeriesNames(final String name) {
            super(name);
        }

        /**
         * インスタンスを構築します。
         * 
         * @param parent
         *            親
         * @param name
         *            名前
         */
        public _MovieSeriesNames(final PropertyName<?> parent, final String name) {
            super(parent, name);
        }

        /**
         * sidのプロパティ名を返します。
         *
         * @return sidのプロパティ名
         */
        public PropertyName<Integer> sid() {
            return new PropertyName<Integer>(this, "sid");
        }

        /**
         * snumのプロパティ名を返します。
         *
         * @return snumのプロパティ名
         */
        public PropertyName<Integer> snum() {
            return new PropertyName<Integer>(this, "snum");
        }

        /**
         * midのプロパティ名を返します。
         *
         * @return midのプロパティ名
         */
        public PropertyName<Integer> mid() {
            return new PropertyName<Integer>(this, "mid");
        }

        /**
         * stitleのプロパティ名を返します。
         *
         * @return stitleのプロパティ名
         */
        public PropertyName<String> stitle() {
            return new PropertyName<String>(this, "stitle");
        }

        /**
         * spicのプロパティ名を返します。
         *
         * @return spicのプロパティ名
         */
        public PropertyName<String> spic() {
            return new PropertyName<String>(this, "spic");
        }

        /**
         * stimeのプロパティ名を返します。
         *
         * @return stimeのプロパティ名
         */
        public PropertyName<Integer> stime() {
            return new PropertyName<Integer>(this, "stime");
        }

        /**
         * sdateのプロパティ名を返します。
         *
         * @return sdateのプロパティ名
         */
        public PropertyName<Date> sdate() {
            return new PropertyName<Date>(this, "sdate");
        }

        /**
         * SDeadFlgのプロパティ名を返します。
         *
         * @return SDeadFlgのプロパティ名
         */
        public PropertyName<Byte> SDeadFlg() {
            return new PropertyName<Byte>(this, "SDeadFlg");
        }

        /**
         * compFlgのプロパティ名を返します。
         *
         * @return compFlgのプロパティ名
         */
        public PropertyName<Byte> compFlg() {
            return new PropertyName<Byte>(this, "compFlg");
        }

        /**
         * roleのプロパティ名を返します。
         *
         * @return roleのプロパティ名
         */
        public PropertyName<String> role() {
            return new PropertyName<String>(this, "role");
        }

        /**
         * totalPlayのプロパティ名を返します。
         *
         * @return totalPlayのプロパティ名
         */
        public PropertyName<Integer> totalPlay() {
            return new PropertyName<Integer>(this, "totalPlay");
        }

        /**
         * pattern1のプロパティ名を返します。
         *
         * @return pattern1のプロパティ名
         */
        public PropertyName<String> pattern1() {
            return new PropertyName<String>(this, "pattern1");
        }

        /**
         * temp1のプロパティ名を返します。
         *
         * @return temp1のプロパティ名
         */
        public PropertyName<Integer> temp1() {
            return new PropertyName<Integer>(this, "temp1");
        }

        /**
         * temp2のプロパティ名を返します。
         *
         * @return temp2のプロパティ名
         */
        public PropertyName<String> temp2() {
            return new PropertyName<String>(this, "temp2");
        }

        /**
         * temp3のプロパティ名を返します。
         *
         * @return temp3のプロパティ名
         */
        public PropertyName<Integer> temp3() {
            return new PropertyName<Integer>(this, "temp3");
        }

        /**
         * temp4のプロパティ名を返します。
         *
         * @return temp4のプロパティ名
         */
        public PropertyName<String> temp4() {
            return new PropertyName<String>(this, "temp4");
        }

        /**
         * movieInfoのプロパティ名を返します。
         * 
         * @return movieInfoのプロパティ名
         */
        public _MovieInfoNames movieInfo() {
            return new _MovieInfoNames(this, "movieInfo");
        }
    }
}