package com.assets.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2017/5/17 0017.
 */

    /*单位表*/
@Entity
@Table(name = "unit")
public class Unit implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String unitName; //单位名称

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }



    public Unit(String unitName){
        this.unitName=unitName;
    }
    public Unit(){}
}
