package com.assets.service;

import com.assets.dao.SupplierDao;
import com.assets.entity.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * Created by hflyf on 2017/5/23.
 */
@Service
public class SupplierService {
    @Autowired
    SupplierDao supplierDao;
    public Supplier addSupplier(Supplier supplier){
        return supplierDao.save(supplier);
    }
    public void delSupplier(Integer id){
        supplierDao.delete(id);
    }
    public boolean updateSupplier (Supplier supplier){
        return supplierDao.saveAndFlush(supplier)!=null;
    }
    public Page<Supplier> findAll(Pageable pageable){
        return supplierDao.findAll(pageable);
    }
    public Supplier findone(Integer id){
        return supplierDao.findOne(id);
    }


}
