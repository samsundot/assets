package com.assets.dao;

import com.assets.entity.CostCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2017/5/23 0023.
 */
@Repository
public interface CostCenterDao extends JpaRepository<CostCenter,Integer> {
}
