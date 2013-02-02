package jp.co.omana.entity;

import javax.annotation.Generated;
import jp.co.omana.entity.MasterCatNames._MasterCatNames;
import jp.co.omana.entity.MovieInfoNames._MovieInfoNames;
import org.seasar.extension.jdbc.name.PropertyName;

/**
 * {@link MovieCat}のプロパティ名の集合です。
 * 
 */
@Generated(value = {"S2JDBC-Gen 2.4.45", "org.seasar.extension.jdbc.gen.internal.model.NamesModelFactoryImpl"}, date = "2013/02/03 5:37:14")
public class MovieCatNames {

    /**
     * movieInfoMidのプロパティ名を返します。
     * 
     * @return movieInfoMidのプロパティ名
     */
    public static PropertyName<Integer> movieInfoMid() {
        return new PropertyName<Integer>("movieInfoMid");
    }

    /**
     * masterCatCatidのプロパティ名を返します。
     * 
     * @return masterCatCatidのプロパティ名
     */
    public static PropertyName<Integer> masterCatCatid() {
        return new PropertyName<Integer>("masterCatCatid");
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
     * masterCatのプロパティ名を返します。
     * 
     * @return masterCatのプロパティ名
     */
    public static _MasterCatNames masterCat() {
        return new _MasterCatNames("masterCat");
    }

    /**
     * @author S2JDBC-Gen
     */
    public static class _MovieCatNames extends PropertyName<MovieCat> {

        /**
         * インスタンスを構築します。
         */
        public _MovieCatNames() {
        }

        /**
         * インスタンスを構築します。
         * 
         * @param name
         *            名前
         */
        public _MovieCatNames(final String name) {
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
        public _MovieCatNames(final PropertyName<?> parent, final String name) {
            super(parent, name);
        }

        /**
         * movieInfoMidのプロパティ名を返します。
         *
         * @return movieInfoMidのプロパティ名
         */
        public PropertyName<Integer> movieInfoMid() {
            return new PropertyName<Integer>(this, "movieInfoMid");
        }

        /**
         * masterCatCatidのプロパティ名を返します。
         *
         * @return masterCatCatidのプロパティ名
         */
        public PropertyName<Integer> masterCatCatid() {
            return new PropertyName<Integer>(this, "masterCatCatid");
        }

        /**
         * movieInfoのプロパティ名を返します。
         * 
         * @return movieInfoのプロパティ名
         */
        public _MovieInfoNames movieInfo() {
            return new _MovieInfoNames(this, "movieInfo");
        }

        /**
         * masterCatのプロパティ名を返します。
         * 
         * @return masterCatのプロパティ名
         */
        public _MasterCatNames masterCat() {
            return new _MasterCatNames(this, "masterCat");
        }
    }
}