package com.assets.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Administrator on 2017/5/17 0017.
 */
/*采购信息*/
@Entity
@Table(name = "procurement")
public class Procurement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String orderNumber;//采购订单号
    private Date arrivalDate; //到货日期
    private String buyer;  //采购员
    private String accepter; //验收人
    @ManyToOne(cascade = {CascadeType.ALL }, optional = false)//Cascade 级联操作
    @JoinColumn(name = "supplierId")
    private Supplier supplier; //供应商标识
    private Date createTime;
}
