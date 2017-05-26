package com.assets.service;

import com.assets.dao.AssetDao;
import com.assets.dao.ManufacturersDao;
import com.assets.entity.Asset;
import com.assets.entity.Manufacturers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

/**
 * Created by hch on 2017/5/22.
 */
@Service
@Transactional
public class AssetService {
    @Autowired
    AssetDao assetDao;
    @PersistenceUnit
    private EntityManagerFactory emf;
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

    //修改资产类型
    public boolean updateassetTypeId(Integer setId,Integer assetTypeId){
        return assetDao.updateassetTypeId(setId,assetTypeId)>0;
    }
    //修改资产位置
    public boolean updateLocationId(Integer setId,Integer locationId){
        return assetDao.updateLocationId(setId,locationId)>0;
    }


    public void test(){
        System.out.println("emf"+emf.hashCode());
        System.out.println("em"+emf.createEntityManager().hashCode());
    }

}

