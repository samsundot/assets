package com.assets.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by hch on 2017/5/22.
 */
//部门
@Entity
@Table(name = "department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String department;
    private String description;//
    private String departmentManager;//
    private String managerAlternate;//经理候补
    private String costCenterId;//成本中心
    private String note;//备注
    private String annualBudget;//年度预算
    private String approvalLimits;//每个请求项的批准限制

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
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
}

