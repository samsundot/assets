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
    private String code;
    private String buyer;  //采购员
    private String company; //公司
    private String subclass; //小类
    private Date createTime; //创建时间
 }
