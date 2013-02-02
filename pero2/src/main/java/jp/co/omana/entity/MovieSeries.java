package jp.co.omana.entity;

import java.io.Serializable;
import java.sql.Date;
import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 * MovieSeriesエンティティクラス
 *
 */
@Entity
@Generated(value = {"S2JDBC-Gen 2.4.45", "org.seasar.extension.jdbc.gen.internal.model.EntityModelFactoryImpl"}, date = "2012/10/21 1:59:17")
public class MovieSeries implements Serializable {

    private static final long serialVersionUID = 1L;

    /** sidプロパティ */
    @Id
    @Column(precision = 10, nullable = false, unique = false)
    public Integer sid;

    /** snumプロパティ */
    @Id
    @Column(precision = 10, nullable = false, unique = false)
    public Integer snum;

    /** midプロパティ */
    @Column(precision = 10, nullable = true, unique = false)
    public Integer mid;

    /** stitleプロパティ */
    @Column(length = 255, nullable = false, unique = false)
    public String stitle;

    /** spicプロパティ */
    @Column(length = 255, nullable = false, unique = false)
    public String spic;

    /** stimeプロパティ */
    @Column(precision = 10, nullable = false, unique = false)
    public Integer stime;

    /** sdateプロパティ */
    @Column(nullable = false, unique = false)
    public Date sdate;

    /** SDeadFlgプロパティ */
    @Column(precision = 3, nullable = true, unique = false)
    public Byte SDeadFlg;

    /** compFlgプロパティ */
    @Column(precision = 3, nullable = true, unique = false)
    public Byte compFlg;

    /** roleプロパティ */
    @Column(length = 2, nullable = false, unique = false)
    public String role;

    /** totalPlayプロパティ */
    @Column(precision = 10, nullable = false, unique = false)
    public Integer totalPlay;

    /** pattern1プロパティ */
    @Column(length = 255, nullable = true, unique = false)
    public String pattern1;

    /** temp1プロパティ */
    @Column(precision = 10, nullable = true, unique = false)
    public Integer temp1;

    /** temp2プロパティ */
    @Column(length = 255, nullable = true, unique = false)
    public String temp2;

    /** temp3プロパティ */
    @Column(precision = 10, nullable = true, unique = false)
    public Integer temp3;

    /** temp4プロパティ */
    @Column(length = 255, nullable = true, unique = false)
    public String temp4;

    /**
     * テーブル関連のプロパティ宣言
     */

    /**     * MovieInfo関連プロパティ*/
    @OneToOne
    @JoinColumn(name="MID",referencedColumnName="MID")
    public MovieInfo movieInfo;


}