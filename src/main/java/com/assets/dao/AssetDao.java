package com.assets.dao;

import com.assets.entity.Asset;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by hch on 2017/5/23.
 */
@Repository
public interface AssetDao extends JpaRepository<Asset,Integer>{
    @Modifying @Query(value = "UPDATE asset SET asset_type_id =?1 WHERE asset_type_id =?2 ",nativeQuery = true)
    int updateassetTypeId(Integer setId,Integer assetTypeId);

    @Modifying @Query(value = "UPDATE asset SET location_id =?1 WHERE location_id =?2 ",nativeQuery = true)
    int updateLocationId(Integer setId,Integer LocationId);
}