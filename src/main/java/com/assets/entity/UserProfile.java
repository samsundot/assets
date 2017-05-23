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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
