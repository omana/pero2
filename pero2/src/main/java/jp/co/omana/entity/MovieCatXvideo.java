package jp.co.omana.entity;

import java.io.Serializable;
import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * MovieCatXvideoエンティティクラス
 *
 */
@Entity
@Generated(value = {"S2JDBC-Gen 2.4.45", "org.seasar.extension.jdbc.gen.internal.model.EntityModelFactoryImpl"}, date = "2012/10/21 1:59:17")
public class MovieCatXvideo implements Serializable {

    private static final long serialVersionUID = 1L;

    /** movieInfoMidプロパティ */
    @Id
    @Column(precision = 10, nullable = false, unique = true)
    public Integer movieInfoMid;

    /** tagプロパティ */
    @Column(length = 255, nullable = true, unique = false)
    public String tag;

    /** movieInfo関連プロパティ */
    @ManyToOne
    @JoinColumn(name="MOVIE_INFO_MID", referencedColumnName ="MID")
    public MovieInfo movieInfo;


}