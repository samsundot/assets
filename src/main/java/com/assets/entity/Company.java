package com.assets.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by hch on 2017/5/22.
 */
//公司
@Entity
@Table(name = "company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String companyName;//公司名称
    private String description;//说明
    private String companyPresident;// 公司总裁
    private String node;//备注
    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCompanyPresident() {
        return companyPresident;
    }

    public void setCompanyPresident(String companyPresident) {
        this.companyPresident = companyPresident;
    }

    public String getNode() {
        return node;
    }

    public void setNode(String node) {
        this.node = node;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
