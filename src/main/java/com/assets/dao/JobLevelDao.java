package com.assets.dao;

import com.assets.entity.Asset;
import com.assets.entity.JobLevel;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by hch on 2017/5/23.
 */
public interface JobLevelDao extends JpaRepository<JobLevel,Integer>{
}
