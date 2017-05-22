package com.assets.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Administrator on 2017/5/18 0018.
 */

    /*规格型号*/
@Entity
@Table(name = "norms")
public class Norms {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String  norms; //规格型号
    private String maintenancePeriod; //维保期
    private String color; //颜色
    private String cpu;
    private String memory; //内存
    private String hardDisk; //硬盘
    private String size; //尺寸
    private String rom; //光驱
    private String note; //备注
    private String spacing; //间距
    private String cabinetType; // 机柜类型
    private String power; //功率
    private Date createTime; //创建时间
}
