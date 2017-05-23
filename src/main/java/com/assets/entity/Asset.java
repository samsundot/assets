package com.assets.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Administrator on 2017/5/17 0017.
 */

/*资产信息*/
@Entity
@Table(name = "asset")
public class Asset {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column
    private String assetId; //资产标识
    @Column
    private String assetName; //资产名称
    @Column
    private String assetDesc; //资产描述
    @Column
    private String assetState; //资产状态

    @Column
    private String secondary; //次级
    @Column
    private String spaId; // spa编号
    @Column
    private String thoseResponsible; //责任人
    @ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.REFRESH }, optional = true)//Cascade 级联操作
    @JoinColumn(name = "normsId")
    private Norms norms;//规格型号
    @ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.REFRESH }, optional = true)//Cascade 级联操作
    @JoinColumn(name = "assetTypeId")
    private  AssetType assetType;
    @ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.REFRESH }, optional = true)//Cascade 级联操作
    @JoinColumn(name = "locationId")
    private Location location;
    @ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.REFRESH }, optional = true)//Cascade 级联操作
    @JoinColumn(name = "costCenterId")
    private CostCenter costCenter;
    @ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.REFRESH }, optional = true)//Cascade 级联操作
    @JoinColumn(name = "procurementId")
    private Procurement procurement;
    @ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.REFRESH }, optional = true)//Cascade 级联操作
    @JoinColumn(name = "financialId")
    private Financial financial;
    @Column
    private Date createTime; //创建时间
    @Column
    private Date updateTime; //更新时间

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAssetId() {
        return assetId;
    }

    public void setAssetId(String assetId) {
        this.assetId = assetId;
    }

    public String getAssetName() {
        return assetName;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }

    public String getAssetDesc() {
        return assetDesc;
    }

    public void setAssetDesc(String assetDesc) {
        this.assetDesc = assetDesc;
    }

    public String getAssetState() {
        return assetState;
    }

    public void setAssetState(String assetState) {
        this.assetState = assetState;
    }

    public String getSecondary() {
        return secondary;
    }

    public void setSecondary(String secondary) {
        this.secondary = secondary;
    }

    public String getSpaId() {
        return spaId;
    }

    public void setSpaId(String spaId) {
        this.spaId = spaId;
    }

    public String getThoseResponsible() {
        return thoseResponsible;
    }

    public void setThoseResponsible(String thoseResponsible) {
        this.thoseResponsible = thoseResponsible;
    }

    public Norms getNorms() {
        return norms;
    }

    public void setNorms(Norms norms) {
        this.norms = norms;
    }

    public AssetType getAssetType() {
        return assetType;
    }

    public void setAssetType(AssetType assetType) {
        this.assetType = assetType;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public CostCenter getCostCenter() {
        return costCenter;
    }

    public void setCostCenter(CostCenter costCenter) {
        this.costCenter = costCenter;
    }

    public Procurement getProcurement() {
        return procurement;
    }

    public void setProcurement(Procurement procurement) {
        this.procurement = procurement;
    }

    public Financial getFinancial() {
        return financial;
    }

    public void setFinancial(Financial financial) {
        this.financial = financial;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
