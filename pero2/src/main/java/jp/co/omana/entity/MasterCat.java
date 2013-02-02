package jp.co.omana.entity;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * MasterCatエンティティクラス
 *
 */
@Entity
@Generated(value = {"S2JDBC-Gen 2.4.45", "org.seasar.extension.jdbc.gen.internal.model.EntityModelFactoryImpl"}, date = "2012/10/21 1:59:17")
public class MasterCat implements Serializable {

    private static final long serialVersionUID = 1L;

    /** catidプロパティ */
    @Id
    @Column(precision = 10, nullable = false, unique = true)
    public Integer catid;

    /** catNameプロパティ */
    @Column(length = 255, nullable = false, unique = false)
    public String catName;


    /**   * MovieCat関連プロパティ     */
    @OneToMany(mappedBy = "masterCat")
    public List<MovieCat> movieCatList;
}