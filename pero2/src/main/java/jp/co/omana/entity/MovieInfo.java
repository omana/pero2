package jp.co.omana.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 * MovieInfoエンティティクラス
 *
 */
@Entity
@Generated(value = {"S2JDBC-Gen 2.4.45", "org.seasar.extension.jdbc.gen.internal.model.EntityModelFactoryImpl"}, date = "2012/10/21 1:59:17")
public class MovieInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /** midプロパティ */
    @Id
    @Column(precision = 10, nullable = false, unique = true)
    public Integer mid;

    /** mtitleプロパティ */
    @Column(length = 255, nullable = false, unique = false)
    public String mtitle;

    /** mtimeプロパティ */
    @Column(length = 255, nullable = false, unique = false)
    public String mtime;

    /** mdateプロパティ */
    @Column(nullable = false, unique = false)
    public Date mdate;

    /** mpicプロパティ */
    @Column(length = 255, nullable = false, unique = false)
    public String mpic;

    /** deadFlgプロパティ */
    @Column(precision = 3, nullable = true, unique = false)
    public Byte deadFlg;

    /** detailUrlプロパティ */
    @Column(length = 255, nullable = true, unique = true)
    public String detailUrl;

    /** temp1プロパティ */
    @Column(length = 255, nullable = true, unique = false)
    public String temp1;

    /** temp2プロパティ */
    @Column(length = 255, nullable = true, unique = false)
    public String temp2;

    /** temp3プロパティ */
    @Column(length = 255, nullable = true, unique = false)
    public String temp3;

    /** editFlgプロパティ */
    @Column(precision = 10, nullable = true, unique = false)
    public Integer editFlg;

    /**
     * テーブル関連のプロパティ宣言
     */

    /** MovieCat関連プロパティ */
    @OneToMany(mappedBy = "movieInfo")
    public List<MovieCat> movieCatList;

    /** MovieCat関連プロパティ */
    @OneToMany(mappedBy = "movieInfo")
    public List<MovieCatXvideo> movieCatXvideoList;

    /**     * MovieSeries関連プロパティ     */
    @OneToOne(mappedBy="movieInfo")
    public MovieSeries movieSeries;


}