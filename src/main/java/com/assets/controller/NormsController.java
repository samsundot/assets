package com.assets.controller;

import com.alibaba.fastjson.JSONObject;
import com.assets.core.constant.Const;
import com.assets.core.controller.BaseController;
import com.assets.core.util.JsonUtil;
import com.assets.core.util.Result;
import com.assets.entity.*;
import com.assets.service.AssetService;
import com.assets.service.NormsService;
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
public class NormsController extends BaseController{
    private static final Logger logger = LoggerFactory.getLogger(NormsController.class);
    @Autowired
    NormsService normsService;


    @PostMapping("/norms")
    public Result addNorms(@RequestBody String requestBody){
        try {
            JSONObject parse = JsonUtil.parse(requestBody);
            String norm = (String)JsonUtil.getObject(parse, "norm");
            String maintenancePeriod = (String) JsonUtil.getObject(parse, "maintenancePeriod");
            String color = (String) JsonUtil.getObject(parse, "color");
            String memory = (String) JsonUtil.getObject(parse, "memory");
            String cpu = (String) JsonUtil.getObject(parse, "cpu");
            String hardDisk = (String) JsonUtil.getObject(parse, "hardDisk");
            String size = (String) JsonUtil.getObject(parse, "size");
            String rom = (String)JsonUtil.getObject(parse, "rom");
            String note = (String)JsonUtil.getObject(parse, "note");
            String spacing = (String)JsonUtil.getObject(parse, "spacing");
            String cabinetType = (String)JsonUtil.getObject(parse, "cabinetType");
            String power = (String)JsonUtil.getObject(parse, "power");


                Norms norms = new Norms();
                norms.setNorms(norm);
                norms.setCabinetType(cabinetType);
                norms.setColor(color);
                norms.setCpu(cpu);
                norms.setHardDisk(hardDisk);
                norms.setMaintenancePeriod(maintenancePeriod);
                norms.setMemory(memory);
                norms.setNote(note);
                norms.setPower(power);
                norms.setRom(rom);
                norms.setSize(size);
                norms.setSpacing(spacing);
                normsService.addNorms(norms);
            return success("添加成功");
        }catch (Exception e){
            logger.error("未知错误",e);
            return error("服务器内部异常");
        }
    }

    @DeleteMapping("/norms/{normsId}")
    public Result assetNorms(@PathVariable("normsId")String normsId){
        try {
            normsService.delNorms(Integer.valueOf(normsId));
            return success("删除成功");
        }catch (Exception e){
            e.printStackTrace();
            logger.error("未知错误",e);
            return error("服务器内部异常");
        }

    }

    @PutMapping("/norms/{normsId}")
    public Result updateNorms(@PathVariable("normsId")String normsId,@RequestBody String requestBody){
        try {
            JSONObject parse = JsonUtil.parse(requestBody);
            String norm = (String)JsonUtil.getObject(parse, "norm");
            String maintenancePeriod = (String) JsonUtil.getObject(parse, "maintenancePeriod");
            String color = (String) JsonUtil.getObject(parse, "color");
            String memory = (String) JsonUtil.getObject(parse, "memory");
            String cpu = (String) JsonUtil.getObject(parse, "cpu");
            String hardDisk = (String) JsonUtil.getObject(parse, "hardDisk");
            String size = (String) JsonUtil.getObject(parse, "size");
            String rom = (String)JsonUtil.getObject(parse, "rom");
            String note = (String)JsonUtil.getObject(parse, "note");
            String spacing = (String)JsonUtil.getObject(parse, "spacing");
            String cabinetType = (String)JsonUtil.getObject(parse, "cabinetType");
            String power = (String)JsonUtil.getObject(parse, "power");


            Norms norms = new Norms();
            norms.setNorms(norm);
            norms.setCabinetType(cabinetType);
            norms.setColor(color);
            norms.setCpu(cpu);
            norms.setHardDisk(hardDisk);
            norms.setMaintenancePeriod(maintenancePeriod);
            norms.setMemory(memory);
            norms.setNote(note);
            norms.setPower(power);
            norms.setRom(rom);
            norms.setSize(size);
            norms.setSpacing(spacing);

            boolean b = normsService.updateNorms(norms);
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

    @GetMapping("/norms")
    public Result normsList(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                    @RequestParam(value = "size", defaultValue = "30") Integer size){
        try {
            Sort sort = new Sort(Sort.Direction.DESC, "id");
            Pageable pageable = new PageRequest(page-1, size, sort);
            //查询所有
            return success(normsService.findAll(pageable));
        }catch (Exception e){
            logger.error("未知错误",e);
            return error("服务器内部异常");
        }

    }

    @GetMapping("/norms/{normsId}")
    public Result norms(@PathVariable("normsId")String normsId){
        try {
            return success(normsService.findOne(Integer.valueOf(normsId)));
        }catch (Exception e){
            logger.error("未知错误",e);
            return error("服务器内部异常");
        }

    }


}
