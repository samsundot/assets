package com.assets.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Administrator on 2017/5/18 0018.
 */
/*验收组*/
@Entity
@Table(name = "assessgroup")
public class AssessGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column
    private String code;
    @Column
    private String buyer;  //验收员
    @ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.REFRESH }, optional = true)//Cascade 级联操作
    @JoinColumn(name = "companyId")
    private Company company; //公司
    @Column
    private String subclass; //小类


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getSubclass() {
        return subclass;
    }

    public void setSubclass(String subclass) {
        this.subclass = subclass;
    }


}
