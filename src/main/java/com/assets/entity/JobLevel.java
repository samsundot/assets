package com.assets.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by hch on 2017/5/22.
 */
//职务级别
@Entity
@Table(name = "joblevel")
public class JobLevel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String jobName;//职务名
    private String description;//说明
    private Date createTime;
}
