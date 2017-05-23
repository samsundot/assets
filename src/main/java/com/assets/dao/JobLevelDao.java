package com.assets.dao;

import com.assets.entity.Asset;
import com.assets.entity.JobLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by hch on 2017/5/23.
 */
@Repository
public interface JobLevelDao extends JpaRepository<JobLevel,Integer>{

}
