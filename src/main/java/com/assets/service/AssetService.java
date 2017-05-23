package com.assets.service;

import com.assets.dao.AssetDao;
import com.assets.dao.ManufacturersDao;
import com.assets.entity.Asset;
import com.assets.entity.Manufacturers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * Created by hch on 2017/5/22.
 */
@Service
public class AssetService {
    @Autowired
    AssetDao assetDao;

    public Asset addAsset(Asset asset){
        return assetDao.save(asset);
    }

    public void delAsset(Integer id){
        assetDao.delete(id);
    }

    public Page<Asset> findAll(Pageable pageable) {
        return assetDao.findAll(pageable);
    }
    public boolean updateAsset(Asset asset){
        return assetDao.saveAndFlush(asset)!=null;
    }
    public Asset findOne(Integer id){
        return assetDao.findOne(id);
    }
}
