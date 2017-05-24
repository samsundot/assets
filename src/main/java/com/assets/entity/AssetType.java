package com.assets.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2017/5/17 0017.
 */
/*资产分类*/
@Entity
@Table(name = "assettype")
public class AssetType implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String assetTypeName;//资产类别名称
    private Integer parentTypeId; //上级类别名称
    private String assetTypeLevel; //资产类别级别
    private String description; //说明
    private Date createTime; //创建时间


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

    public Integer getParentTypeId() {
        return parentTypeId;
    }

    public void setParentTypeId(Integer parentTypeId) {
        this.parentTypeId = parentTypeId;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
