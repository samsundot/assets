package com.assets.service;

import com.assets.dao.UnitDao;
import com.assets.entity.Unit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/5/23 0023.
 */
@Service
public class UnitService {
    @Autowired
    UnitDao unitDao;
    //新增
    public Unit addUnit(Unit unit){
        return unitDao.save(unit);
    }
    //删除
    public void deleteUnit(Integer id){
        unitDao.delete(id);
    }
    //修改
    public boolean updateUnit(Unit unit){
        return unitDao.saveAndFlush(unit) != null;
    }
    //查询所有
    public Page<Unit> findAll(Pageable pageable){
        return unitDao.findAll(pageable);
    }
    //查询单个
    public Unit findOne(Integer id){
        return unitDao.findOne(id);
    }
}
