package com.assets.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2017/5/17 0017.
 */
/*财务信息*/
@Entity
public class Financial implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Long originalCost;//原值
    private Long netWorth; //净值
    private Date purchaseDate;//购置日期
    private Date capitalizationDate;   //资本化日期
    private Date deactivationDate;   //资产不活动日期
    private Date planRetirementDate; //计划报废日期
    private Date shutdownDate; //停用日期

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getOriginalCost() {
        return originalCost;
    }

    public void setOriginalCost(Long originalCost) {
        this.originalCost = originalCost;
    }

    public Long getNetWorth() {
        return netWorth;
    }

    public void setNetWorth(Long netWorth) {
        this.netWorth = netWorth;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public Date getCapitalizationDate() {
        return capitalizationDate;
    }

    public void setCapitalizationDate(Date capitalizationDate) {
        this.capitalizationDate = capitalizationDate;
    }

    public Date getDeactivationDate() {
        return deactivationDate;
    }

    public void setDeactivationDate(Date deactivationDate) {
        this.deactivationDate = deactivationDate;
    }

    public Date getPlanRetirementDate() {
        return planRetirementDate;
    }

    public void setPlanRetirementDate(Date planRetirementDate) {
        this.planRetirementDate = planRetirementDate;
    }

    public Date getShutdownDate() {
        return shutdownDate;
    }

    public void setShutdownDate(Date shutdownDate) {
        this.shutdownDate = shutdownDate;
    }
}
