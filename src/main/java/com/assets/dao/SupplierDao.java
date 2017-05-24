package com.assets.dao;

import com.assets.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by hflyf on 2017/5/23.
 */
@Repository
public interface SupplierDao extends JpaRepository<Supplier,Integer> {

}

