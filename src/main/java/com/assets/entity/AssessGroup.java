package com.assets.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Administrator on 2017/5/18 0018.
 */
/*验收组*/
@Entity
@Table(name = "assessgroup")
public class AssessGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column
    private String code;
    @Column
    private String buyer;  //验收员
    @Column
    private String company; //公司
    @Column
    private String subclass; //小类ß
    @Column
    private Date createTime; //创建时间

}
