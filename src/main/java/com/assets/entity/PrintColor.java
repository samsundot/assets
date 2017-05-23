package com.assets.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Administrator on 2017/5/19.
 */
/*打印颜色*/
@Entity
@Table(name = "printcolor")
public class PrintColor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;//颜色名称

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
