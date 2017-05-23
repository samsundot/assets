package com.assets.service;

import com.assets.dao.AssetDao;
import com.assets.dao.NormsDao;
import com.assets.entity.Asset;
import com.assets.entity.Norms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * Created by hch on 2017/5/22.
 */
@Service
public class NormsService {
    @Autowired
    NormsDao normsDao;

    public Norms addNorms(Norms norms){
        return normsDao.save(norms);
    }

    public void delNorms(Integer id){
        normsDao.delete(id);
    }

    public Page<Norms> findAll(Pageable pageable) {
        return normsDao.findAll(pageable);
    }
    public boolean updateNorms(Norms norms){
        return normsDao.saveAndFlush(norms)!=null;
    }
    public Norms findOne(Integer id){
        return normsDao.findOne(id);
    }
}

