package com.assets.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Administrator on 2017/5/17 0017.
 */

    /*单位表*/
@Entity
@Table(name = "unit")
public class Unit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String unitName; //单位名称
    private Date createTime; //创建时间
}
