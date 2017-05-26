package com.assets.entity;


import com.alibaba.fastjson.annotation.JSONField;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2017/5/17 0017.
 */
/*资产分类*/
@Entity
public class AssetType implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String assetTypeName;//资产类别名称
    private String assetTypeLevel; //资产类别级别
    private String description; //说明

    /**
     * 上级分类
     */
    @JSONField(serialize = false)
    @ManyToOne(optional = true,fetch = FetchType.LAZY)
    private AssetType assetType;
    /**
     * 下级分类
     */
    @OneToMany(cascade={CascadeType.REFRESH,CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE}
            ,fetch = FetchType.LAZY,mappedBy = "assetType")
    private Set<AssetType> assetTypes=new HashSet();



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAssetTypeName() {
        return assetTypeName;
    }

    public void setAssetTypeName(String assetTypeName) {
        this.assetTypeName = assetTypeName;
    }

    public String getAssetTypeLevel() {
        return assetTypeLevel;
    }

    public void setAssetTypeLevel(String assetTypeLevel) {
        this.assetTypeLevel = assetTypeLevel;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public AssetType getAssetType() {
        return assetType;
    }

    public void setAssetType(AssetType assetType) {
        this.assetType = assetType;
    }

    public Set<AssetType> getAssetTypes() {
        return assetTypes;
    }

    public void setAssetTypes(Set<AssetType> assetTypes) {
        this.assetTypes = assetTypes;
    }
}
