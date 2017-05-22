package com.assets.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Administrator on 2017/5/17 0017.
 */
/*财务信息*/
@Entity
@Table(name = "financial")
public class Financial {
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
}
