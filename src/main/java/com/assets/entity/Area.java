package com.assets.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by hch on 2017/5/22.
 */
//区域
@Entity
@Table(name = "area")
public class Area {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String area;
    private String description;//
    private String departmentManager;//
    private String managerAlternate;//经理候补
    private String costCenterId;//成本中心
    private String note;//备注
    private String annualBudget;//年度预算
    private String approvalLimits;//每个请求项的批准限制
    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDepartmentManager() {
        return departmentManager;
    }

    public void setDepartmentManager(String departmentManager) {
        this.departmentManager = departmentManager;
    }

    public String getManagerAlternate() {
        return managerAlternate;
    }

    public void setManagerAlternate(String managerAlternate) {
        this.managerAlternate = managerAlternate;
    }

    public String getCostCenterId() {
        return costCenterId;
    }

    public void setCostCenterId(String costCenterId) {
        this.costCenterId = costCenterId;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getAnnualBudget() {
        return annualBudget;
    }

    public void setAnnualBudget(String annualBudget) {
        this.annualBudget = annualBudget;
    }

    public String getApprovalLimits() {
        return approvalLimits;
    }

    public void setApprovalLimits(String approvalLimits) {
        this.approvalLimits = approvalLimits;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Area(String area, String description, String departmentManager, String managerAlternate, String costCenterId, String note, String annualBudget, String approvalLimits, Date createTime) {
        this.area = area;
        this.description = description;
        this.departmentManager = departmentManager;
        this.managerAlternate = managerAlternate;
        this.costCenterId = costCenterId;
        this.note = note;
        this.annualBudget = annualBudget;
        this.approvalLimits = approvalLimits;
        this.createTime = createTime;
    }

    public Area() {
    }
}
