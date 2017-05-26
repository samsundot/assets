package com.assets.service;

import com.assets.dao.AssetTypeDao;
import com.assets.dao.LocationDao;
import com.assets.entity.AssetType;
import com.assets.entity.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by hch on 2017/5/22.
 */
@Service
public class LocationService {
    @Autowired
    LocationDao locationDao;

    public Location addLocation(Location location){
        return locationDao.save(location);
    }

    public void delLocation(Integer id){
        locationDao.delete(id);
    }

    public List<Location> findAll() {
        return locationDao.findAll();
    }
//    查一级菜单
    public List<Location> findByLocationLevel(String assetTypeLevel) {
        return locationDao.findByLocationLevel(assetTypeLevel);
    }

    public boolean updateLocation(Location location){
        return locationDao.saveAndFlush(location)!=null;
    }
    //  查下一级菜单
    public List<Location> findByParentId(Integer pid){
        return locationDao.findByLocationParent(pid);
    }


}

