package jp.co.omana.entity;

import javax.annotation.Generated;
import jp.co.omana.entity.MasterCatNames._MasterCatNames;
import jp.co.omana.entity.MovieCatNames._MovieCatNames;
import jp.co.omana.entity.MovieCatXvideoNames._MovieCatXvideoNames;
import jp.co.omana.entity.MovieInfoNames._MovieInfoNames;
import jp.co.omana.entity.MovieSeriesNames._MovieSeriesNames;

/**
 * 名前クラスの集約です。
 * 
 */
@Generated(value = {"S2JDBC-Gen 2.4.45", "org.seasar.extension.jdbc.gen.internal.model.NamesAggregateModelFactoryImpl"}, date = "2013/02/03 5:37:14")
public class Names {

    /**
     * {@link MasterCat}の名前クラスを返します。
     * 
     * @return MasterCatの名前クラス
     */
    public static _MasterCatNames masterCat() {
        return new _MasterCatNames();
    }

    /**
     * {@link MovieCat}の名前クラスを返します。
     * 
     * @return MovieCatの名前クラス
     */
    public static _MovieCatNames movieCat() {
        return new _MovieCatNames();
    }

    /**
     * {@link MovieCatXvideo}の名前クラスを返します。
     * 
     * @return MovieCatXvideoの名前クラス
     */
    public static _MovieCatXvideoNames movieCatXvideo() {
        return new _MovieCatXvideoNames();
    }

    /**
     * {@link MovieInfo}の名前クラスを返します。
     * 
     * @return MovieInfoの名前クラス
     */
    public static _MovieInfoNames movieInfo() {
        return new _MovieInfoNames();
    }

    /**
     * {@link MovieSeries}の名前クラスを返します。
     * 
     * @return MovieSeriesの名前クラス
     */
    public static _MovieSeriesNames movieSeries() {
        return new _MovieSeriesNames();
    }
}