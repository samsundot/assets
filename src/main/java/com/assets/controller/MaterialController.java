package com.assets.controller;

import com.alibaba.fastjson.JSONObject;
import com.assets.core.controller.BaseController;
import com.assets.core.util.JsonUtil;
import com.assets.core.util.Result;
import com.assets.entity.Material;
import com.assets.service.MaterialService;
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
public class MaterialController extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(MaterialController.class);
    @Autowired
    MaterialService materialService;

    @PostMapping("/material")
    public Result addMaterial(@RequestBody String requestBody) {
        try {
            JSONObject json = JsonUtil.parse(requestBody);//将字符串转为json对象
            String name = (String) JsonUtil.getObject(json, "materialName");//从对象中去值
            Material material = new Material(name);
            materialService.addMaterial(material);
            return success("添加成功");
        } catch (Exception e) {
            logger.error("未知错误", e);
            return error("服务器内部异常");
        }
    }

    @DeleteMapping("/material/{materialId}")
    public Result delMaterial(@PathVariable("materialId") String materialId) {
        try {
            materialService.delMaterial(Integer.valueOf(materialId));
            return success("删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("未知错误", e);
            return error("服务器内部异常");
        }
    }

    @PutMapping("/material/{materialId}")
    public Result UpdateMaterial(@PathVariable("materialId") String materialId,
                                 @RequestBody String requestBody) {
        try {
            JSONObject json = JsonUtil.parse(requestBody);//将字符串转为json对象
            String name = (String) JsonUtil.getObject(json, "materialName");//从对象中去值
            Material material = new Material();
            material.setId(Integer.valueOf(materialId));
            material.setName(name);
            boolean b = materialService.updateMaterial(material);
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

    @GetMapping("/material")
    public Result materialList(@RequestParam(value = "page", defaultValue = "1") Integer page,
                               @RequestParam(value = "size", defaultValue = "30") Integer size) {
        try {
            Sort sort = new Sort(Sort.Direction.DESC, "id");
            Pageable pageable = new PageRequest(page - 1, size, sort);
            //查询所有
            return success(materialService.findAll(pageable));
        } catch (Exception e) {
            logger.error("未知错误", e);
            return error("服务器内部异常");
        }

    }

    //根据id查
    @GetMapping("/material/{materialId}")
    public Result material(@PathVariable("materialId") String materialId) {
        try {
            return success(materialService.findOne(Integer.valueOf(materialId)));
        } catch (Exception e) {
            logger.error("未知错误", e);
            return error("服务器内部异常");
        }
    }
}
