package jp.co.omana.entity;

import java.io.Serializable;
import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * MovieCatエンティティクラス
 *
 */
@Entity
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "MOVIE_INFO_MID", "MASTER_CAT_CATID" }) })
@Generated(value = {"S2JDBC-Gen 2.4.45", "org.seasar.extension.jdbc.gen.internal.model.EntityModelFactoryImpl"}, date = "2012/10/21 1:59:17")
public class MovieCat implements Serializable {

    private static final long serialVersionUID = 1L;

    /** movieInfoMidプロパティ */
    @Id
    @Column(precision = 10, nullable = false, unique = true)
    public Integer movieInfoMid;

    /** masterCatCatidプロパティ */
    @Column(precision = 10, nullable = false, unique = false)
    public Integer masterCatCatid;

    /** movieInfo関連プロパティ */
    @ManyToOne
    @JoinColumn(name="MOVIE_INFO_MID", referencedColumnName ="MID")
    public MovieInfo movieInfo;

    /**  masterCat関連プロパティ     */
    @ManyToOne
    @JoinColumn(name="MASTER_CAT_CATID", referencedColumnName="CATID")
    public MasterCat masterCat;
}