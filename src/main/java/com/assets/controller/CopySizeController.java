package com.assets.controller;

import com.alibaba.fastjson.JSONObject;
import com.assets.core.controller.BaseController;
import com.assets.core.util.JsonUtil;
import com.assets.core.util.Result;
import com.assets.entity.CopySize;
import com.assets.service.CopySizeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 2017/5/24.
 */
@RestController
public class CopySizeController extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(CopySizeController.class);
    @Autowired
    CopySizeService copySizeService;

    @PostMapping("/copysize")
    public Result addCopySize(@RequestBody String requestBody) {
        try {
            JSONObject json = JsonUtil.parse(requestBody);//将字符串转为json对象
            String name = (String) JsonUtil.getObject(json, "copySizeName");//从对象中去值
            CopySize copySize = new CopySize(name);
            copySizeService.addCopySize(copySize);
            return success("添加成功");
        } catch (Exception e) {
            logger.error("未知错误", e);
            return error("服务器内部异常");
        }
    }

    @DeleteMapping("/copysize/{copysizeId}")
    public Result delCopySize(@PathVariable("copysizeId") String copysizeId) {
        try {
            copySizeService.delCopySize(Integer.valueOf(copysizeId));
            return success("删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("未知错误", e);
            return error("服务器内部异常");
        }
    }

    @PutMapping("/copysize/{copysizeId}")
    public Result UpdateCopySize(@PathVariable("copysizeId") String copysizeId, @RequestBody String requestBody) {
        try {
            JSONObject json = JsonUtil.parse(requestBody);//将字符串转为json对象
            String name = (String) JsonUtil.getObject(json, "copySizeName");//从对象中去值
            CopySize copySize = new CopySize();
            copySize.setId(Integer.valueOf(copysizeId));
            copySize.setName(name);
            boolean b = copySizeService.updateCopySize(copySize);
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

    @GetMapping("/copysize")
    public Result copysizeList(@RequestParam(value = "page", defaultValue = "1") Integer page,
                               @RequestParam(value = "size", defaultValue = "30") Integer size) {
        try {
            Sort sort = new Sort(Sort.Direction.DESC, "id");
            Pageable pageable = new PageRequest(page - 1, size, sort);
            //查询所有
            return success(copySizeService.findAll(pageable));
        } catch (Exception e) {
            logger.error("未知错误", e);
            return error("服务器内部异常");
        }

    }

    //根据id查
    @GetMapping("/copysize/{copysizeId}")
    public Result copysize(@PathVariable("copysizeId") String copysizeId) {
        try {
            return success(copySizeService.findOne(Integer.valueOf(copysizeId)));
        } catch (Exception e) {
            logger.error("未知错误", e);
            return error("服务器内部异常");
        }
    }
}
