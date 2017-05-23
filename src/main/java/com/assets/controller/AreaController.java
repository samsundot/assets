package com.assets.controller;

import com.alibaba.fastjson.JSONObject;
import com.assets.core.constant.Const;
import com.assets.core.controller.BaseController;
import com.assets.core.util.JsonUtil;
import com.assets.core.util.Result;
import com.assets.entity.Area;
import com.assets.service.AreaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

/**
 * Created by hflyf on 2017/5/22.
 */
@RestController
public class AreaController extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(AreaController.class);
    @Autowired
    AreaService areaService;

    @PostMapping("/area")
    public Result addArea(@RequestBody String requestBody) {
        try {
        JSONObject parse = JsonUtil.parse(requestBody);

        String area = (String)JsonUtil.getObject(parse,"area");
        String description= (String)JsonUtil.getObject(parse,"description");
        String departmentManager= (String)JsonUtil.getObject(parse,"departmentManager");
        String managerAlternate= (String)JsonUtil.getObject(parse,"managerAlternate");
        String costCenterId= (String)JsonUtil.getObject(parse,"costCenterId");
        String note= (String)JsonUtil.getObject(parse,"note");
        String annualBudget= (String)JsonUtil.getObject(parse,"annualBudget");
        String approvalLimits= (String)JsonUtil.getObject(parse,"approvalLimits");
            Area area1=new Area(area,description,departmentManager,managerAlternate,costCenterId,note,annualBudget,approvalLimits,Const.TIMESTAMP);
            areaService.addArea(area1);

        return success("添加成功");
    }catch (Exception e){
        logger.error("未知错误",e);
        return error("服务器内部异常");
    }
    }
    @DeleteMapping("/area/{areaId}")
    public Result areaList(@PathVariable("areaId")String areaId){
       try {
           areaService.delArea(Integer.valueOf(areaId));
           return success("删除成功");
       }
    catch (Exception e){
        e.printStackTrace();
        logger.error("未知错误",e);
        return error("服务器内部异常");


    }

    }

    @PutMapping("/area/{areaId}")
    public Result updateArea(@PathVariable("areaId")String areaId,@RequestBody String requestBody){
        try {
            JSONObject parse = JsonUtil.parse(requestBody);
            String area = (String) JsonUtil.getObject(parse, "area");
            String description = (String) JsonUtil.getObject(parse, "description");
            String departmentManager = (String) JsonUtil.getObject(parse, "departmentManager");
            String managerAlternate = (String) JsonUtil.getObject(parse, "managerAlternate");
            String costCenterId = (String) JsonUtil.getObject(parse, "costCenterId");
            String note = (String) JsonUtil.getObject(parse, "note");
            String annualBudget = (String) JsonUtil.getObject(parse, "annualBudget");
            String approvalLimits = (String) JsonUtil.getObject(parse, "approvalLimits");
            Area area1 = new Area();
            area1.setId(Integer.valueOf(areaId));
            area1.setArea(area);
            area1.setDescription(description);
            area1.setDepartmentManager(departmentManager);
            area1.setManagerAlternate(managerAlternate);
            area1.setCostCenterId(costCenterId);
            area1.setNote(note);
            area1.setAnnualBudget(annualBudget);
            area1.setApprovalLimits(approvalLimits);
            boolean b = areaService.updateArea(area1);
            if (b) {
                return success("修改成功");
            }
            return error("修改失败");
        }catch (Exception e){
            e.printStackTrace();
            logger.error("未知错误",e);
            return error("服务器内部异常");
        }
    }
    @GetMapping("/area")
    public Result manufacturersList(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                    @RequestParam(value = "size", defaultValue = "30") Integer size){
        try {
            Sort sort = new Sort(Sort.Direction.DESC, "time");
            Pageable pageable = new PageRequest(page-1, size, sort);
            //查询所有
            return success(areaService.findAll(pageable));
        }catch (Exception e){
            logger.error("未知错误",e);
            return error("服务器内部异常");
        }

    }
    @GetMapping("/area/{areaId}")
    public Result area(@PathVariable("areaId")String areaId){
        try {
            return success(areaService.findone(Integer.valueOf(areaId)));
        }catch (Exception e){
            logger.error("未知错误",e);
            return error("服务器内部异常");
        }

    }
}
