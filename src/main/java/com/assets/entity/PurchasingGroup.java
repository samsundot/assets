package com.assets.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Administrator on 2017/5/18 0018.
 */

/*采购组*/
@Entity
@Table(name = "purchasinggroup")
public class PurchasingGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String buyer;  //采购员
    private String company; //公司
    private String subclass; //小类

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getSubclass() {
        return subclass;
    }

    public void setSubclass(String subclass) {
        this.subclass = subclass;
    }


}
