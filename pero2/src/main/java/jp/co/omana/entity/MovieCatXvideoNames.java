package jp.co.omana.entity;

import javax.annotation.Generated;
import jp.co.omana.entity.MovieInfoNames._MovieInfoNames;
import org.seasar.extension.jdbc.name.PropertyName;

/**
 * {@link MovieCatXvideo}のプロパティ名の集合です。
 * 
 */
@Generated(value = {"S2JDBC-Gen 2.4.45", "org.seasar.extension.jdbc.gen.internal.model.NamesModelFactoryImpl"}, date = "2013/02/03 5:37:14")
public class MovieCatXvideoNames {

    /**
     * movieInfoMidのプロパティ名を返します。
     * 
     * @return movieInfoMidのプロパティ名
     */
    public static PropertyName<Integer> movieInfoMid() {
        return new PropertyName<Integer>("movieInfoMid");
    }

    /**
     * tagのプロパティ名を返します。
     * 
     * @return tagのプロパティ名
     */
    public static PropertyName<String> tag() {
        return new PropertyName<String>("tag");
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
    public static class _MovieCatXvideoNames extends PropertyName<MovieCatXvideo> {

        /**
         * インスタンスを構築します。
         */
        public _MovieCatXvideoNames() {
        }

        /**
         * インスタンスを構築します。
         * 
         * @param name
         *            名前
         */
        public _MovieCatXvideoNames(final String name) {
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
        public _MovieCatXvideoNames(final PropertyName<?> parent, final String name) {
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
         * tagのプロパティ名を返します。
         *
         * @return tagのプロパティ名
         */
        public PropertyName<String> tag() {
            return new PropertyName<String>(this, "tag");
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