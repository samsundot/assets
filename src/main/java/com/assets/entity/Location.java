package com.assets.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Administrator on 2017/5/17 0017.
 */
/*资产存放位置*/
@Entity
@Table(name = "location")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;
    private String locationName; //地点名称
    private String detailedAddress; //详细地址
    private Integer parentLocationId; //上级地址标识
    private String locationLevel; //地址级别
    private Date createTime; //创建时间
}
//地点名称，说明，地点地址，建筑物，房间号，楼层，地点编码，经理，维护，父级地点
