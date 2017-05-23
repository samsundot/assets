package com.assets.dao;

import com.assets.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2017/5/23 0023.
 */
@Repository

public interface CompanyDao extends JpaRepository<Company,Integer> {
}
