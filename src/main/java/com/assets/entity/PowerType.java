package com.assets.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Administrator on 2017/5/19.
 */
/*动力类型*/
@Entity
@Table(name = "powertype")
public class PowerType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer serialNumber;//序号
    private String name;//类型名称
    private Date createTime; //创建时间
}
