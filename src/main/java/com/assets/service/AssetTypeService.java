package com.assets.service;

import com.assets.dao.AssetDao;
import com.assets.dao.AssetTypeDao;
import com.assets.entity.Asset;
import com.assets.entity.AssetType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import java.util.List;

/**
 * Created by hch on 2017/5/22.
 */
@Service
public class AssetTypeService {
    @Autowired
    AssetTypeDao assetTypeDao;

    public AssetType addAssetType(AssetType assetType){
        return assetTypeDao.save(assetType);
    }

    public void delAssetType(Integer id){
        assetTypeDao.delete(id);
    }

    public List<AssetType> findAll() {
        return assetTypeDao.findAll();
    }
//    查一级菜单
    public List<AssetType> findByAssetTypeLevel(String assetTypeLevel) {
        return assetTypeDao.findByAssetTypeLevel(assetTypeLevel);
    }

    public boolean updateAssetType(AssetType assetType){
        return assetTypeDao.saveAndFlush(assetType)!=null;
    }


}

