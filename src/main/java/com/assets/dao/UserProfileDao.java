package com.assets.dao;

import com.assets.entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2017/5/24 0024.
 */
@Repository
public interface UserProfileDao extends JpaRepository<UserProfile,Integer> {
}
