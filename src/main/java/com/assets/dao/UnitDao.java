package com.assets.dao;

import com.assets.entity.Unit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2017/5/23 0023.
 */
@Repository

public interface UnitDao extends JpaRepository<Unit,Integer>{

}
