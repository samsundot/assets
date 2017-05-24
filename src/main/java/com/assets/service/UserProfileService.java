package com.assets.service;

import com.assets.dao.UserProfileDao;
import com.assets.entity.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/5/24 0024.
 */
@Service
public class UserProfileService {
    @Autowired
    UserProfileDao userProfileDao;
    //添加
    public UserProfile addUserProfile(UserProfile userProfile){
        return userProfileDao.save(userProfile);
    }
    //修改
    public boolean updateUserProfile(UserProfile userProfile){
        return userProfileDao.saveAndFlush(userProfile) != null;
    }
    //删除
    public void deleteUserProfile(Integer id){
        userProfileDao.delete(id);
    }
    //查询全部
    public Page<UserProfile> findAll(Pageable pageable){
        return userProfileDao.findAll(pageable);
    }
    //c查询单个
    public UserProfile findOne(Integer id){
        return userProfileDao.findOne(id);
    }
}
