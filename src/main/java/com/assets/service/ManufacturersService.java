package com.assets.service;

import com.assets.dao.ManufacturersDao;
import com.assets.entity.Manufacturers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * Created by hch on 2017/5/22.
 */
@Service
public class ManufacturersService {
    @Autowired
    ManufacturersDao manufacturersDao;

    public Manufacturers addManufacturers(Manufacturers manufacturers){
        return manufacturersDao.save(manufacturers);
    }

    public void delManufacturers(Integer id){
        manufacturersDao.delete(id);
    }

    public Page<Manufacturers> findAll(Pageable pageable) {
        return manufacturersDao.findAll(pageable);
    }
    public boolean updateManufacturers(Manufacturers manufacturers){
        return manufacturersDao.saveAndFlush(manufacturers)!=null;
    }
    public Manufacturers findOne(Integer id){
        return manufacturersDao.findOne(id);
    }
}

