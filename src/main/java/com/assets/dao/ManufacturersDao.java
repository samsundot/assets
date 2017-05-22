package com.assets.dao;

import com.assets.entity.Manufacturers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by hch on 2017/5/22.
 */
@Repository
public interface ManufacturersDao extends JpaRepository<Manufacturers,Integer>{

}
