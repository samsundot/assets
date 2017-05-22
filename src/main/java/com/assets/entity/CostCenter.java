package com.assets.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Administrator on 2017/5/17 0017.
 */
@Entity
@Table(name = "costcenter")
/*成本中心*/
public class CostCenter {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String code;
    private String costCenterName; //成本中心名称
    private String costCenterDesc;  //成本中心描述
    private Date createTime; //创建时间
}
