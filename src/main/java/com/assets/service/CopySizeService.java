package com.assets.service;

import com.assets.dao.CopySizeDao;
import com.assets.entity.CopySize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/5/24.
 */
@Service
public class CopySizeService {
    @Autowired
    CopySizeDao copySizeDao;

    public CopySize addCopySize(CopySize copySize) {
        return copySizeDao.save(copySize);
    }

    public void delCopySize(Integer id) {
        copySizeDao.delete(id);
    }

    public Page<CopySize> findAll(Pageable pageable) {
        return copySizeDao.findAll(pageable);
    }

    public boolean updateCopySize(CopySize copySize) {
        return copySizeDao.saveAndFlush(copySize) != null;
    }
    public CopySize findOne(Integer id){
        return copySizeDao.findOne(id);
    }
}
