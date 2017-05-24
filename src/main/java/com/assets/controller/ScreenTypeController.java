package com.assets.controller;

import com.alibaba.fastjson.JSONObject;
import com.assets.core.controller.BaseController;
import com.assets.core.util.JsonUtil;
import com.assets.core.util.Result;
import com.assets.entity.ScreenType;
import com.assets.service.ScreenTypeService;
import com.sun.glass.ui.Screen;
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
public class ScreenTypeController extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(ScreenTypeController.class);
    @Autowired
    ScreenTypeService screenTypeService;

    @PostMapping("/screentype")
    public Result addScreenType(@RequestBody String requestBody){
        try {
        JSONObject json= JsonUtil.parse(requestBody);//将字符串转为json对象
        String showType=(String)JsonUtil.getObject(json, "screenShowType");//从对象中去值
        ScreenType screenType=new ScreenType(showType);
        screenTypeService.addScreenType(screenType);
        return success("添加成功");
        }catch (Exception e){
            logger.error("未知错误",e);
            return error("服务器内部异常");
        }
    }
    @DeleteMapping("/screentype/{screentypeId}")
    public Result delScreenType(@PathVariable("screentypeId")String screentypeId){
        try {
            screenTypeService.delScreenType(Integer.valueOf(screentypeId));
            return success("删除成功");
        }catch (Exception e){
            e.printStackTrace();
            logger.error("未知错误",e);
            return error("服务器内部异常");
        }
    }
    @PutMapping("/screentype/{screentypeId}")
    public Result UpdateScreenType(@PathVariable("screentypeId")String screentypeId,@RequestBody String requestBody){
        try {
        JSONObject json= JsonUtil.parse(requestBody);//将字符串转为json对象
        String showType=(String)JsonUtil.getObject(json, "screenShowType");//从对象中去值
        ScreenType screenType=new ScreenType();
        screenType.setId(Integer.valueOf(screentypeId));
        screenType.setShowType(showType);
            boolean b = screenTypeService.updateScreenType(screenType);
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
    @GetMapping("/screentype")
    public Result screentypeList(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                    @RequestParam(value = "size", defaultValue = "30") Integer size){
        try {
            Sort sort = new Sort(Sort.Direction.DESC, "id");
            Pageable pageable = new PageRequest(page-1, size, sort);
            //查询所有
            return success(screenTypeService.findAll(pageable));
        }catch (Exception e){
            logger.error("未知错误",e);
            return error("服务器内部异常");
        }

    }
    //根据id查
    @GetMapping("/screentype/{screentypeId}")
    public Result screentype(@PathVariable("screentypeId")String screentypeId){
        try {
            return success(screenTypeService.findOne(Integer.valueOf(screentypeId)));
        }catch (Exception e){
            logger.error("未知错误",e);
            return error("服务器内部异常");
        }

    }

}
