package com.assets.controller;

import com.alibaba.fastjson.JSONObject;
import com.assets.core.controller.BaseController;
import com.assets.core.util.JsonUtil;
import com.assets.core.util.Result;
import com.assets.entity.HouseStructure;
import com.assets.service.HouseStructureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 2017/5/25.
 */
@RestController
public class HouseStructureController extends BaseController{
    private static final Logger logger = LoggerFactory.getLogger(HouseStructureController.class);
    @Autowired
    HouseStructureService houseStructureService;
    @PostMapping("/housestructure")
    public Result addHouseStructure(@RequestBody String requestBody) {
        try {
            JSONObject json = JsonUtil.parse(requestBody);//将字符串转为json对象
            String name = (String) JsonUtil.getObject(json, "houseStructureName");//从对象中去值
            HouseStructure houseStructure = new HouseStructure(name);
            houseStructureService.addHouseStructure(houseStructure);
            return success("添加成功");
        } catch (Exception e) {
            logger.error("未知错误", e);
            return error("服务器内部异常");
        }
    }

    @DeleteMapping("/housestructure/{housestructureId}")
    public Result delHouseStructure(@PathVariable("housestructureId") String housestructureId) {
        try {
            houseStructureService.delHouseStructure(Integer.valueOf(housestructureId));
            return success("删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("未知错误", e);
            return error("服务器内部异常");
        }
    }

    @PutMapping("/housestructure/{housestructureId}")
    public Result UpdateHouseStructure(@PathVariable("housestructureId") String housestructureId,
                                       @RequestBody String requestBody) {
        try {
            JSONObject json = JsonUtil.parse(requestBody);//将字符串转为json对象
            String name = (String) JsonUtil.getObject(json, "houseStructureName");//从对象中去值
            HouseStructure houseStructure = new HouseStructure();
            houseStructure.setId(Integer.valueOf(housestructureId));
            houseStructure.setName(name);
            boolean b = houseStructureService.updateHouseStructure(houseStructure);
            if (b) {
                return success("修改成功");
            }
            return error("修改失败");

        } catch (Exception e) {
            e.printStackTrace();
            logger.error("未知错误", e);
            return error("服务器内部异常");
        }
    }

    @GetMapping("/housestructure")
    public Result housestructureList(@RequestParam(value = "page", defaultValue = "1") Integer page,
                               @RequestParam(value = "size", defaultValue = "30") Integer size) {
        try {
            Sort sort = new Sort(Sort.Direction.DESC, "id");
            Pageable pageable = new PageRequest(page - 1, size, sort);
            //查询所有
            return success(houseStructureService.findAll(pageable));
        } catch (Exception e) {
            logger.error("未知错误", e);
            return error("服务器内部异常");
        }

    }

    //根据id查
    @GetMapping("/housestructure/{housestructureId}")
    public Result housestructure(@PathVariable("housestructureId") String housestructureId) {
        try {
            return success(houseStructureService.findOne(Integer.valueOf(housestructureId)));
        } catch (Exception e) {
            logger.error("未知错误", e);
            return error("服务器内部异常");
        }
    }
}
