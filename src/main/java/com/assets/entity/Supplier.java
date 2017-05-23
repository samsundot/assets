package com.assets.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Administrator on 2017/5/17 0017.
 */

/*供应商品牌*/
@Entity
@Table(name = "supplier")
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String supplierName;
    private String supplierType;
    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getSupplierType() {
        return supplierType;
    }

    public void setSupplierType(String supplierType) {
        this.supplierType = supplierType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
//供应商名称，供应商类型，供应商ID,外部供应商ID，生命周期状态，公司地址，专门技术年限，创建公司年份，提供

