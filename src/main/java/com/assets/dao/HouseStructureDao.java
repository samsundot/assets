package com.assets.dao;

import com.assets.entity.HouseStructure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2017/5/25.
 */
@Repository
public interface HouseStructureDao extends JpaRepository<HouseStructure,Integer> {
}
