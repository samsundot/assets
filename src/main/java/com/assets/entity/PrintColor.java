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
    private Integer serialNumber;//序号
    private String name;//颜色名称
    private Date createTime; //创建时间
}
