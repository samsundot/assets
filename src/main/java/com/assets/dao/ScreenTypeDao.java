package com.assets.dao;

import com.assets.entity.ScreenType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2017/5/24.
 */
@Repository
public interface ScreenTypeDao extends JpaRepository<ScreenType,Integer> {
}
