package com.assets.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Administrator on 2017/5/19.
 */
/*打印尺寸*/
@Entity
@Table(name = "printsize")
public class PrintSize {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer serialNumber;//序号
    private String name;//尺寸名称
    private Date createTime; //创建时间
}
