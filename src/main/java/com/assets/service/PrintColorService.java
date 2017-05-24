package com.assets.service;

import com.assets.dao.PrintColorDao;
import com.assets.entity.PrintColor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/5/24.
 */
@Service
public class PrintColorService {
    @Autowired
    PrintColorDao printColorDao;
    public PrintColor addPrintColor(PrintColor printColor){
        return printColorDao.save(printColor);
    }

    public void delPrintColor(Integer id){
        printColorDao.delete(id);
    }

    public Page<PrintColor> findAll(Pageable pageable) {
        return printColorDao.findAll(pageable);
    }
    public boolean updatePrintColor(PrintColor printColor){
        return printColorDao.saveAndFlush(printColor)!=null;
    }
    public PrintColor findOne(Integer id){
        return printColorDao.findOne(id);
}
}
