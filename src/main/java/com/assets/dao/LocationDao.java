package com.assets.dao;

import com.assets.entity.AssetType;
import com.assets.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by hch on 2017/5/23.
 */
@Repository
public interface LocationDao extends JpaRepository<Location,Integer>{
    List<Location> findByLocationLevel(String locationLevel);
    List<Location> findByLocationParent(Integer pid);
}
