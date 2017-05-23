package com.assets.controller;

import com.alibaba.fastjson.JSONObject;
import com.assets.core.constant.Const;
import com.assets.core.controller.BaseController;
import com.assets.core.util.JsonUtil;
import com.assets.core.util.Result;
import com.assets.entity.CostCenter;
import com.assets.entity.Unit;
import com.assets.service.CostCenterService;
import com.assets.service.UnitService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2017/5/23 0023.
 */
@RestController
public class CostCenterController extends BaseController{
    private static final Logger logger = LoggerFactory.getLogger(CostCenterController.class);
    @Autowired
    CostCenterService costCenterService;

    //新增
    @PostMapping("/addCostCenter")
    public Result addCostCenter(@RequestBody String requestBody){
        try {
            JSONObject parse = JsonUtil.parse(requestBody);
            String code = (String)JsonUtil.getObject(parse, "code");
            String costCenterName = (String)JsonUtil.getObject(parse, "costCenterName");
            String costCenterDesc = (String)JsonUtil.getObject(parse, "costCenterDesc");
            CostCenter costCenter = new CostCenter();
            costCenter.setCode(code);
            costCenter.setCostCenterName(costCenterName);
            costCenter.setCostCenterDesc(costCenterDesc);
            Date date = new Date();
            costCenter.setCreateTime(date);
            costCenterService.addCostCenter(costCenter);
            return success("添加成功");
        }catch (Exception e){
            logger.error("未知错误",e);
            return error("服务器内部异常");
        }
    }
    //删除
    @DeleteMapping("/deleteCostCenter/{id}")
    public Result deleteCostCenter(@PathVariable("id")String id){
        try {
            costCenterService.deleteCostCenter(Integer.valueOf(id));
            return success("删除成功");
        }catch (Exception e){
            e.printStackTrace();
            logger.error("未知错误",e);
            return error("服务器内部异常");
        }

    }
    //修改
    @PutMapping("/updateCostCenter/{id}")
    public Result updateCostCenter(@PathVariable("id")String id,@RequestBody String requestBody){
        try {
            JSONObject parse = JsonUtil.parse(requestBody);
            String code = (String)JsonUtil.getObject(parse, "code");
            String costCenterName = (String)JsonUtil.getObject(parse, "costCenterName");
            String costCenterDesc = (String)JsonUtil.getObject(parse, "costCenterDesc");
            CostCenter costCenter = new CostCenter();
            costCenter.setId(Integer.valueOf(id));
            costCenter.setCode(code);
            costCenter.setCostCenterName(costCenterName);
            costCenter.setCostCenterDesc(costCenterDesc);
            boolean b = costCenterService.updateCostCenter(costCenter);
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

    @GetMapping("/costCenter")
    public Result costCenterList(@RequestParam(value = "page", defaultValue = "1") Integer page,
                           @RequestParam(value = "size", defaultValue = "30") Integer size){
        try {
            Sort sort = new Sort(Sort.Direction.DESC, "id");
            Pageable pageable = new PageRequest(page-1, size, sort);
            //查询所有
            return success(costCenterService.findAll(pageable));
        }catch (Exception e){
            logger.error("未知错误",e);
            return error("服务器内部异常");
        }

    }

    @GetMapping("/costCenterById/{id}")
    public Result costCenterById(@PathVariable("id")String id) {
        try {
            return success(costCenterService.findOne(Integer.valueOf(id)));
        } catch (Exception e) {
            logger.error("未知错误", e);
            return error("服务器内部异常");
        }

    }
}


