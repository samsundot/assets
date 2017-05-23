package com.assets.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by hch on 2017/5/22.
 */
//用户配置文件
@Entity
@Table(name = "userprofile")
public class UserProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String  username;
    @ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.REFRESH }, optional = false)//Cascade 级联操作
    @JoinColumn(name = "jobLevelId")
    private JobLevel jobLevel;//职务等级标识
    private String officePhone;
    private String primaryPhone;//主要电话
    private String mobilePhone;//移动电话
    @ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.REFRESH }, optional = false)//Cascade 级联操作
    @JoinColumn(name = "departmentId")
    private Department department;//部门标识
    @ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.REFRESH }, optional = false)//Cascade 级联操作
    @JoinColumn(name = "constCenterId")
    private CostCenter costCenter;//成本中心标识
    private String manager;//经理
    private String note;//备注
    private Date createTime;
}
