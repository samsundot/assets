package com.assets.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by hch on 2017/5/22.
 */
//区域
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
}
