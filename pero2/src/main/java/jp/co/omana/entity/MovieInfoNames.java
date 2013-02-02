package jp.co.omana.entity;

import java.sql.Date;
import javax.annotation.Generated;
import jp.co.omana.entity.MovieCatNames._MovieCatNames;
import jp.co.omana.entity.MovieCatXvideoNames._MovieCatXvideoNames;
import jp.co.omana.entity.MovieSeriesNames._MovieSeriesNames;
import org.seasar.extension.jdbc.name.PropertyName;

/**
 * {@link MovieInfo}のプロパティ名の集合です。
 * 
 */
@Generated(value = {"S2JDBC-Gen 2.4.45", "org.seasar.extension.jdbc.gen.internal.model.NamesModelFactoryImpl"}, date = "2013/02/03 5:37:14")
public class MovieInfoNames {

    /**
     * midのプロパティ名を返します。
     * 
     * @return midのプロパティ名
     */
    public static PropertyName<Integer> mid() {
        return new PropertyName<Integer>("mid");
    }

    /**
     * mtitleのプロパティ名を返します。
     * 
     * @return mtitleのプロパティ名
     */
    public static PropertyName<String> mtitle() {
        return new PropertyName<String>("mtitle");
    }

    /**
     * mtimeのプロパティ名を返します。
     * 
     * @return mtimeのプロパティ名
     */
    public static PropertyName<String> mtime() {
        return new PropertyName<String>("mtime");
    }

    /**
     * mdateのプロパティ名を返します。
     * 
     * @return mdateのプロパティ名
     */
    public static PropertyName<Date> mdate() {
        return new PropertyName<Date>("mdate");
    }

    /**
     * mpicのプロパティ名を返します。
     * 
     * @return mpicのプロパティ名
     */
    public static PropertyName<String> mpic() {
        return new PropertyName<String>("mpic");
    }

    /**
     * deadFlgのプロパティ名を返します。
     * 
     * @return deadFlgのプロパティ名
     */
    public static PropertyName<Byte> deadFlg() {
        return new PropertyName<Byte>("deadFlg");
    }

    /**
     * detailUrlのプロパティ名を返します。
     * 
     * @return detailUrlのプロパティ名
     */
    public static PropertyName<String> detailUrl() {
        return new PropertyName<String>("detailUrl");
    }

    /**
     * temp1のプロパティ名を返します。
     * 
     * @return temp1のプロパティ名
     */
    public static PropertyName<String> temp1() {
        return new PropertyName<String>("temp1");
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
    public static PropertyName<String> temp3() {
        return new PropertyName<String>("temp3");
    }

    /**
     * editFlgのプロパティ名を返します。
     * 
     * @return editFlgのプロパティ名
     */
    public static PropertyName<Integer> editFlg() {
        return new PropertyName<Integer>("editFlg");
    }

    /**
     * movieCatListのプロパティ名を返します。
     * 
     * @return movieCatListのプロパティ名
     */
    public static _MovieCatNames movieCatList() {
        return new _MovieCatNames("movieCatList");
    }

    /**
     * movieCatXvideoListのプロパティ名を返します。
     * 
     * @return movieCatXvideoListのプロパティ名
     */
    public static _MovieCatXvideoNames movieCatXvideoList() {
        return new _MovieCatXvideoNames("movieCatXvideoList");
    }

    /**
     * movieSeriesのプロパティ名を返します。
     * 
     * @return movieSeriesのプロパティ名
     */
    public static _MovieSeriesNames movieSeries() {
        return new _MovieSeriesNames("movieSeries");
    }

    /**
     * @author S2JDBC-Gen
     */
    public static class _MovieInfoNames extends PropertyName<MovieInfo> {

        /**
         * インスタンスを構築します。
         */
        public _MovieInfoNames() {
        }

        /**
         * インスタンスを構築します。
         * 
         * @param name
         *            名前
         */
        public _MovieInfoNames(final String name) {
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
        public _MovieInfoNames(final PropertyName<?> parent, final String name) {
            super(parent, name);
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
         * mtitleのプロパティ名を返します。
         *
         * @return mtitleのプロパティ名
         */
        public PropertyName<String> mtitle() {
            return new PropertyName<String>(this, "mtitle");
        }

        /**
         * mtimeのプロパティ名を返します。
         *
         * @return mtimeのプロパティ名
         */
        public PropertyName<String> mtime() {
            return new PropertyName<String>(this, "mtime");
        }

        /**
         * mdateのプロパティ名を返します。
         *
         * @return mdateのプロパティ名
         */
        public PropertyName<Date> mdate() {
            return new PropertyName<Date>(this, "mdate");
        }

        /**
         * mpicのプロパティ名を返します。
         *
         * @return mpicのプロパティ名
         */
        public PropertyName<String> mpic() {
            return new PropertyName<String>(this, "mpic");
        }

        /**
         * deadFlgのプロパティ名を返します。
         *
         * @return deadFlgのプロパティ名
         */
        public PropertyName<Byte> deadFlg() {
            return new PropertyName<Byte>(this, "deadFlg");
        }

        /**
         * detailUrlのプロパティ名を返します。
         *
         * @return detailUrlのプロパティ名
         */
        public PropertyName<String> detailUrl() {
            return new PropertyName<String>(this, "detailUrl");
        }

        /**
         * temp1のプロパティ名を返します。
         *
         * @return temp1のプロパティ名
         */
        public PropertyName<String> temp1() {
            return new PropertyName<String>(this, "temp1");
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
        public PropertyName<String> temp3() {
            return new PropertyName<String>(this, "temp3");
        }

        /**
         * editFlgのプロパティ名を返します。
         *
         * @return editFlgのプロパティ名
         */
        public PropertyName<Integer> editFlg() {
            return new PropertyName<Integer>(this, "editFlg");
        }

        /**
         * movieCatListのプロパティ名を返します。
         * 
         * @return movieCatListのプロパティ名
         */
        public _MovieCatNames movieCatList() {
            return new _MovieCatNames(this, "movieCatList");
        }

        /**
         * movieCatXvideoListのプロパティ名を返します。
         * 
         * @return movieCatXvideoListのプロパティ名
         */
        public _MovieCatXvideoNames movieCatXvideoList() {
            return new _MovieCatXvideoNames(this, "movieCatXvideoList");
        }

        /**
         * movieSeriesのプロパティ名を返します。
         * 
         * @return movieSeriesのプロパティ名
         */
        public _MovieSeriesNames movieSeries() {
            return new _MovieSeriesNames(this, "movieSeries");
        }
    }
}