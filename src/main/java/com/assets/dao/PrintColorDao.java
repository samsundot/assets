package com.assets.dao;

import com.assets.entity.PrintColor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2017/5/24.
 */
@Repository
public interface PrintColorDao extends JpaRepository<PrintColor,Integer> {
}
