package com.assets.controller;

import com.alibaba.fastjson.JSONObject;
import com.assets.core.controller.BaseController;
import com.assets.core.util.JsonUtil;
import com.assets.core.util.Result;
import com.assets.entity.Company;
import com.assets.entity.CostCenter;
import com.assets.service.CompanyService;
import com.assets.service.CostCenterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * Created by Administrator on 2017/5/23 0023.
 */
@RestController
public class CompanyController extends BaseController{
    private static final Logger logger = LoggerFactory.getLogger(CompanyController.class);
    @Autowired
    CompanyService companyService;

    //新增
    @PostMapping("/addCompany")
    public Result addCompany(@RequestBody String requestBody){
        try {
            JSONObject parse = JsonUtil.parse(requestBody);
            String companyName = (String)JsonUtil.getObject(parse, "companyName");
            String description = (String)JsonUtil.getObject(parse, "description");
            String companyPresident = (String)JsonUtil.getObject(parse, "companyPresident");
            String node = (String)JsonUtil.getObject(parse, "node");
            Company company = new Company();
            company.setCompanyName(companyName);
            company.setDescription(description);
            company.setCompanyPresident(companyPresident);
            company.setNode(node);
            Date date = new Date();
            company.setCreateTime(date);
            companyService.addCompany(company);
            return success("添加成功");
        }catch (Exception e){
            logger.error("未知错误",e);
            return error("服务器内部异常");
        }
    }
    //删除
    @DeleteMapping("/deleteCompany/{id}")
    public Result deleteCompany(@PathVariable("id")String id){
        try {
            companyService.deleteCompany(Integer.valueOf(id));
            return success("删除成功");
        }catch (Exception e){
            e.printStackTrace();
            logger.error("未知错误",e);
            return error("服务器内部异常");
        }

    }
    //修改1
    @PutMapping("/updateCompany/{id}")
    public Result updateCompany(@PathVariable("id")String id,@RequestBody String requestBody){
        try {
            JSONObject parse = JsonUtil.parse(requestBody);
            String companyName = (String)JsonUtil.getObject(parse, "companyName");
            String description = (String)JsonUtil.getObject(parse, "description");
            String companyPresident = (String)JsonUtil.getObject(parse, "companyPresident");
            String node = (String)JsonUtil.getObject(parse, "node");
            Company company = new Company();
            company.setId(Integer.valueOf(id));
            company.setCompanyName(companyName);
            company.setDescription(description);
            company.setCompanyPresident(companyPresident);
            company.setNode(node);
            boolean b = companyService.updateCompany(company);
            if(b){
                return success("修改成功");
            }
            return error("修改失败");
        }catch (Exception e){
            e.printStackTrace();
            logger.error("未知错误",e);
            return error("服务器内部异常");
        }
    }

    @GetMapping("/company")
    public Result companyList(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                 @RequestParam(value = "size", defaultValue = "30") Integer size){
        try {
            Sort sort = new Sort(Sort.Direction.DESC, "id");
            Pageable pageable = new PageRequest(page-1, size, sort);
            //查询所有
            return success(companyService.findAll(pageable));
        }catch (Exception e){
            logger.error("未知错误",e);
            return error("服务器内部异常");
        }

    }

    @GetMapping("/companyById/{id}")
    public Result companyById(@PathVariable("id")String id) {
        try {
            return success(companyService.findOne(Integer.valueOf(id)));
        } catch (Exception e) {
            logger.error("未知错误", e);
            return error("服务器内部异常");
        }

    }
}



