package com.assets.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Administrator on 2017/5/17 0017.
 */
/*资产分类*/
@Entity
@Table(name = "assettype")
public class AssetType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column
    private String assetTypeName;//资产类别名称
    @Column
    private Integer parentTypeId; //上级类别名称
    @Column
    private String assetTypeLevel; //资产类别级别
    @Column
    private Date createTime; //创建时间
}
