package com.assets.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by hch on 2017/5/22.
 */
//
@Entity
//返回JSON数据有时会出现为序列化的错误，因为需要序列化对象有一个属性是一类类型，而你使用了Hibernate的延迟加载所以这里是个Hibernate的代理对象。该代理对象有些属性不能被序列化所以会报错。
//解决办法：在类型上加如下注解把不需要序列化的属性屏蔽掉
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","jobLevel","department","costCenter"})
public class UserProfile implements Serializable{
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public JobLevel getJobLevel() {
        return jobLevel;
    }

    public void setJobLevel(JobLevel jobLevel) {
        this.jobLevel = jobLevel;
    }

    public String getOfficePhone() {
        return officePhone;
    }

    public void setOfficePhone(String officePhone) {
        this.officePhone = officePhone;
    }

    public String getPrimaryPhone() {
        return primaryPhone;
    }

    public void setPrimaryPhone(String primaryPhone) {
        this.primaryPhone = primaryPhone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public CostCenter getCostCenter() {
        return costCenter;
    }

    public void setCostCenter(CostCenter costCenter) {
        this.costCenter = costCenter;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

}
