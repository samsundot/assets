package com.assets.dao;

import com.assets.entity.AssetType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by hch on 2017/5/23.
 */
@Repository
public interface AssetTypeDao extends JpaRepository<AssetType,Integer>{
    List<AssetType> findByAssetTypeLevel(String assetTypeLevel);
    List<AssetType> findByAssetTypeParentId(Integer pid);
}
