package com.assets.service;

import com.assets.dao.PrintSizeDao;
import com.assets.entity.PrintSize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/5/24.
 */
@Service
public class PrintSizeService {
    @Autowired
    PrintSizeDao printSizeDao;
    public PrintSize addPrintSize(PrintSize printSize){
        return printSizeDao.save(printSize);
    }

    public void delPrintSize(Integer id){
        printSizeDao.delete(id);
    }

    public Page<PrintSize> findAll(Pageable pageable) {
        return printSizeDao.findAll(pageable);
    }
    public boolean updatePrintSize(PrintSize printSize){
        return printSizeDao.saveAndFlush(printSize)!=null;
    }
    public PrintSize findOne(Integer id){
        return printSizeDao.findOne(id);
    }
}
