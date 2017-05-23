package com.assets.service;

import com.assets.dao.CostCenterDao;
import com.assets.entity.CostCenter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/5/23 0023.
 */
@Service
public class CostCenterService {
    @Autowired
    CostCenterDao costCenterDao;
    //新增
    public CostCenter addCostCenter(CostCenter costCenter){
        return costCenterDao.save(costCenter);
    }
    //删除
    public void deleteCostCenter(Integer id){
        costCenterDao.delete(id);
    }
    //修改
    public boolean updateCostCenter(CostCenter costCenter){
        return costCenterDao.saveAndFlush(costCenter) != null;
    }
    //查询所有
    public Page<CostCenter> findAll(Pageable pageable){
        return costCenterDao.findAll(pageable);
    }
    //查询单个
    public CostCenter findOne(Integer id){
        return costCenterDao.findOne(id);
    }
}
