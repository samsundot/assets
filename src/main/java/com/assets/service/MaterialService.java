package com.assets.service;

import com.assets.dao.MaterialDao;
import com.assets.entity.Material;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/5/25.
 */
@Service
public class MaterialService {
    @Autowired
    MaterialDao materialDao;
    public Material addMaterial(Material material){
        return materialDao.save(material);
    }

    public void delMaterial(Integer id){
        materialDao.delete(id);
    }

    public Page<Material> findAll(Pageable pageable) {
        return materialDao.findAll(pageable);
    }
    public boolean updateMaterial(Material material){
        return materialDao.saveAndFlush(material)!=null;
    }
    public Material findOne(Integer id){
        return materialDao.findOne(id);
    }
}
