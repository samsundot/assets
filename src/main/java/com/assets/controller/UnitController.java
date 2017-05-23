package com.assets.controller;

import com.alibaba.fastjson.JSONObject;
import com.assets.core.constant.Const;
import com.assets.core.controller.BaseController;
import com.assets.core.util.JsonUtil;
import com.assets.core.util.Result;
import com.assets.entity.Manufacturers;
import com.assets.entity.Unit;
import com.assets.service.ManufacturersService;
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
public class UnitController extends BaseController{
    private static final Logger logger = LoggerFactory.getLogger(UnitController.class);
    @Autowired
    UnitService unitService;

    //新增
    @PostMapping("/addUnit")
    public Result addUnit(@RequestBody String requestBody){
        try {
            JSONObject parse = JsonUtil.parse(requestBody);
            String unitName = (String)JsonUtil.getObject(parse, "unitName");
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            Date date = new Date();
            Unit unit = new Unit(unitName,date);
            unitService.addUnit(unit);
            return success("添加成功");
        }catch (Exception e){
            logger.error("未知错误",e);
            return error("服务器内部异常");
        }
    }
    //删除
    @DeleteMapping("/deleteUnit/{id}")
    public Result deleteUnit(@PathVariable("id")String id){
        try {
            unitService.deleteUnit(Integer.valueOf(id));
            return success("删除成功");
        }catch (Exception e){
            e.printStackTrace();
            logger.error("未知错误",e);
            return error("服务器内部异常");
        }

    }
    //修改
    @PutMapping("/updateUnit/{id}")
    public Result updateUnit(@PathVariable("id")String id,@RequestBody String requestBody){
        try {
            JSONObject parse = JsonUtil.parse(requestBody);
            String unitName = (String)JsonUtil.getObject(parse, "unitName");
            Unit unit = new Unit();
            unit.setId(Integer.valueOf(id));
            unit.setUnitName(unitName);
            unit.setCreateTime(Const.TIMESTAMP);
            boolean b = unitService.updateUnit(unit);
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

    @GetMapping("/unit")
    public Result unitList(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                    @RequestParam(value = "size", defaultValue = "30") Integer size){
        try {
            Sort sort = new Sort(Sort.Direction.DESC, "id");
            Pageable pageable = new PageRequest(page-1, size, sort);
            //查询所有
            return success(unitService.findAll(pageable));
        }catch (Exception e){
            logger.error("未知错误",e);
            return error("服务器内部异常");
        }

    }

    @GetMapping("/unitById/{id}")
    public Result unitById(@PathVariable("id")String id) {
        try {
            return success(unitService.findOne(Integer.valueOf(id)));
        } catch (Exception e) {
            logger.error("未知错误", e);
            return error("服务器内部异常");
        }

    }
}
