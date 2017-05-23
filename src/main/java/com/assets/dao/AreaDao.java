package com.assets.dao;

import com.assets.entity.Area;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by hflyf on 2017/5/22.
 */
@Repository
public interface AreaDao extends JpaRepository <Area,Integer>{
}
