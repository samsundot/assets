package com.assets.service;

import com.assets.dao.HouseStructureDao;
import com.assets.entity.HouseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/5/25.
 */
@Service
public class HouseStructureService {
    @Autowired
    HouseStructureDao houseStructureDao;
    public HouseStructure addHouseStructure(HouseStructure houseStructure){
        return houseStructureDao.save(houseStructure);
    }

    public void delHouseStructure(Integer id){
        houseStructureDao.delete(id);
    }

    public Page<HouseStructure> findAll(Pageable pageable) {
        return houseStructureDao.findAll(pageable);
    }
    public boolean updateHouseStructure(HouseStructure houseStructure){
        return houseStructureDao.saveAndFlush(houseStructure)!=null;
    }
    public HouseStructure findOne(Integer id){
        return houseStructureDao.findOne(id);
    }
}
