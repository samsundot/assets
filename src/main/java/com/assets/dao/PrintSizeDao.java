package com.assets.dao;

import com.assets.entity.PrintSize;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2017/5/24.
 */
@Repository
public interface PrintSizeDao extends JpaRepository<PrintSize,Integer> {
}
