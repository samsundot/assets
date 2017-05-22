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
}
