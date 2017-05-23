package com.assets.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by hch on 2017/5/22.
 */
//制造商
@Entity
@Table(name = "manufacturers")
public class Manufacturers implements Serializable{ @Id
@GeneratedValue(strategy = GenerationType.AUTO)

    private Integer id;
    private String manufacturersName;//制造商名称
    private String description;// 说明
    public Manufacturers(){}
    public Manufacturers(String manufacturersName,String description){
        this.manufacturersName=manufacturersName;
        this.description=description;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getManufacturersName() {
        return manufacturersName;
    }

    public void setManufacturersName(String manufacturersName) {
        this.manufacturersName = manufacturersName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
