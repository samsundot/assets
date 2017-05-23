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
    @ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.REFRESH }, optional = false)//Cascade 级联操作
    @JoinColumn(name = "normsId")
    private Norms norms;//规格型号
    @ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.REFRESH }, optional = false)//Cascade 级联操作
    @JoinColumn(name = "assetTypeId")
    private  AssetType assetType;
    @ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.REFRESH }, optional = false)//Cascade 级联操作
    @JoinColumn(name = "locationId")
    private Location location;
    @ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.REFRESH }, optional = false)//Cascade 级联操作
    @JoinColumn(name = "costCenterId")
    private CostCenter costCenter;
    @ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.REFRESH }, optional = false)//Cascade 级联操作
    @JoinColumn(name = "procurementId")
    private Procurement procurement;
    @ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.REFRESH }, optional = false)//Cascade 级联操作
    @JoinColumn(name = "financialId")
    private Financial financial;
    @Column
    private Date createTime; //创建时间
    @Column
    private Date updateTime; //更新时间


}
