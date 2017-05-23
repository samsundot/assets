package com.assets.service;

import com.assets.dao.AssetDao;
import com.assets.dao.JobLevelDao;
import com.assets.entity.Asset;
import com.assets.entity.JobLevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * Created by hch on 2017/5/22.
 */
@Service
public class JobLevelService {
    @Autowired
    JobLevelDao jobLevelDao;

    public JobLevel addJobLevel(JobLevel jobLevel){
        return jobLevelDao.save(jobLevel);
    }

    public void delJobLevel(Integer id){
        jobLevelDao.delete(id);
    }

    public Page<JobLevel> findAll(Pageable pageable) {
        return jobLevelDao.findAll(pageable);
    }
    public boolean updateJobLevel(JobLevel jobLevel){
        return jobLevelDao.saveAndFlush(jobLevel)!=null;
    }
    public JobLevel findOne(Integer id){
        return jobLevelDao.findOne(id);
    }
}

