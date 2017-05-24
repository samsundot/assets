package com.assets.service;

import com.assets.dao.ScreenTypeDao;
import com.assets.entity.ScreenType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/5/24.
 */
@Service
public class ScreenTypeService {
    @Autowired
    ScreenTypeDao screenTypeDao;
    public ScreenType addScreenType(ScreenType screenType) {
        return screenTypeDao.save(screenType);
    }

    public void delScreenType(Integer id) {
        screenTypeDao.delete(id);
    }

    public Page<ScreenType> findAll(Pageable pageable) {
        return screenTypeDao.findAll(pageable);
    }

    public boolean updateScreenType(ScreenType screenType) {
        return screenTypeDao.saveAndFlush(screenType) != null;
    }
    public ScreenType findOne(Integer id){
        return screenTypeDao.findOne(id);
    }
}
