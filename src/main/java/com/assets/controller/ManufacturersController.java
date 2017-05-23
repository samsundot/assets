package com.assets.controller;

import com.alibaba.fastjson.JSONObject;
import com.assets.core.constant.Const;
import com.assets.core.controller.BaseController;
import com.assets.core.util.JsonUtil;
import com.assets.core.util.Result;
import com.assets.entity.Manufacturers;
import com.assets.service.ManufacturersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

/**
 * Created by hch on 2017/5/22.
 */
@RestController
public class ManufacturersController extends BaseController{
    private static final Logger logger = LoggerFactory.getLogger(ManufacturersController.class);
    @Autowired
    ManufacturersService manufacturersService;


    @PostMapping("/manufacturers")
    public Result addManufacturers(@RequestBody String requestBody){
        try {
            JSONObject parse = JsonUtil.parse(requestBody);
            String manufacturersName = (String)JsonUtil.getObject(parse, "manufacturersName");
            String description = (String)JsonUtil.getObject(parse, "description");
            Manufacturers manufacturers = new Manufacturers(manufacturersName,description);
            manufacturersService.addManufacturers(manufacturers);
            return success("添加成功");
        }catch (Exception e){
            logger.error("未知错误",e);
            return error("服务器内部异常");
        }
    }

    @DeleteMapping("/manufacturers/{manufacturersId}")
    public Result manufacturersList(@PathVariable("manufacturersId")String manufacturersId){
        try {
            manufacturersService.delManufacturers(Integer.valueOf(manufacturersId));
            return success("删除成功");
        }catch (Exception e){
            e.printStackTrace();
            logger.error("未知错误",e);
            return error("服务器内部异常");
        }

    }

    @PutMapping("/manufacturers/{manufacturersId}")
    public Result updateManufacturers(@PathVariable("manufacturersId")String manufacturersId,@RequestBody String requestBody){
        try {
            JSONObject parse = JsonUtil.parse(requestBody);
            String manufacturersName = (String)JsonUtil.getObject(parse, "manufacturersName");
            String description = (String)JsonUtil.getObject(parse, "description");
            Manufacturers manufacturers = new Manufacturers();
            manufacturers.setId(Integer.valueOf(manufacturersId));
            manufacturers.setDescription(description);
            manufacturers.setManufacturersName(manufacturersName);
            boolean b = manufacturersService.updateManufacturers(manufacturers);
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

    @GetMapping("/manufacturers")
    public Result manufacturersList(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                    @RequestParam(value = "size", defaultValue = "30") Integer size){
        try {
            Sort sort = new Sort(Sort.Direction.DESC, "id");
            Pageable pageable = new PageRequest(page-1, size, sort);
            //查询所有
            return success(manufacturersService.findAll(pageable));
        }catch (Exception e){
            logger.error("未知错误",e);
            return error("服务器内部异常");
        }

    }

    @GetMapping("/manufacturers/{manufacturersId}")
    public Result manufacturers(@PathVariable("manufacturersId")String manufacturersId){
        try {
            return success(manufacturersService.findOne(Integer.valueOf(manufacturersId)));
        }catch (Exception e){
            logger.error("未知错误",e);
            return error("服务器内部异常");
        }

    }


}
