package com.assets.service;

import com.assets.dao.AreaDao;
import com.assets.entity.Area;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * Created by hflyf on 2017/5/22.
 */
@Service
public class AreaService {
    @Autowired
    AreaDao areaDao;
    public Area addArea(Area area){
        return areaDao.save(area);
    }
    public void delArea(Integer id){
        areaDao.delete(id);
    }
    public Page<Area> findAll(Pageable pageable){
        return areaDao.findAll(pageable);
    }
    public boolean updateArea (Area area){
        return areaDao.saveAndFlush(area)!=null;
    }
    public Area findone(Integer id){
        return areaDao.findOne(id);
    }
}
