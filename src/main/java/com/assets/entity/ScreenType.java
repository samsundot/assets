package com.assets.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Administrator on 2017/5/19.
 */
/*屏幕类型*/
@Entity
@Table(name = "screenType")
public class ScreenType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer serialNumber;//序号
    private String showType;//屏幕类型
    private Date createTime; //创建时间
}
