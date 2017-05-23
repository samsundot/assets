package com.assets.service;

import com.assets.dao.CompanyDao;
import com.assets.entity.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/5/23 0023.
 */
@Service
public class CompanyService {
    @Autowired
    CompanyDao companyDao;
    //新增
    public Company addCompany(Company company){
        return companyDao.save(company);
    }
    //删除
    public void deleteCompany(Integer id){
        companyDao.delete(id);
    }
    //修改
    public boolean updateCompany(Company company){
        return companyDao.saveAndFlush(company)!= null;
    }
    //查询所有
    public Page<Company> findAll(Pageable pageable){
        return companyDao.findAll(pageable);
    }
    //查询单个
    public Company findOne(Integer id){
        return companyDao.findOne(id);
    }
}
