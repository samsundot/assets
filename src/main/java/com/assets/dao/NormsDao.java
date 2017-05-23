package com.assets.dao;

import com.assets.entity.Asset;
import com.assets.entity.Norms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by hch on 2017/5/23.
 */
@Repository
public interface NormsDao extends JpaRepository<Norms,Integer>{
}
