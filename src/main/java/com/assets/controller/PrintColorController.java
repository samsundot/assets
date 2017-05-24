package com.assets.controller;

import com.alibaba.fastjson.JSONObject;
import com.assets.core.controller.BaseController;
import com.assets.core.util.JsonUtil;
import com.assets.core.util.Result;
import com.assets.entity.PrintColor;
import com.assets.service.PrintColorService;
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
public class PrintColorController extends BaseController{
    private static final Logger logger = LoggerFactory.getLogger(PrintColorController.class);
    @Autowired
    PrintColorService printColorService;
    @PostMapping("/printcolor")
    public Result addPrintColor(@RequestBody String requestBody){
        try {
            JSONObject parse = JsonUtil.parse(requestBody);
            String name = (String)JsonUtil.getObject(parse, "printcolorName");
            PrintColor printColor = new PrintColor(name);
            printColorService.addPrintColor(printColor);
            return success("添加成功");
        }catch (Exception e){
            logger.error("未知错误",e);
            return error("服务器内部异常");
        }
    }

    @DeleteMapping("/printcolor/{printcolorId}")
    public Result printcolorList(@PathVariable("printcolorId")String printcolorId){
        try {
            printColorService.delPrintColor(Integer.valueOf(printcolorId));
            return success("删除成功");
        }catch (Exception e){
            e.printStackTrace();
            logger.error("未知错误",e);
            return error("服务器内部异常");
        }

    }

    @PutMapping("/printcolor/{printcolorId}")
    public Result updatePrintColor(@PathVariable("printcolorId")String printcolorId,
                                   @RequestBody String requestBody){
        try {
            JSONObject parse = JsonUtil.parse(requestBody);
            String name = (String)JsonUtil.getObject(parse, "printcolorName");
            PrintColor printColor= new PrintColor();
            printColor.setId(Integer.valueOf(printcolorId));
            printColor.setName(name);
            boolean b = printColorService.updatePrintColor(printColor);
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

    @GetMapping("/printcolor")
    public Result printcolorList(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                @RequestParam(value = "size", defaultValue = "30") Integer size){
        try {
            Sort sort = new Sort(Sort.Direction.DESC, "id");
            Pageable pageable = new PageRequest(page-1, size, sort);
            //查询所有
            return success(printColorService.findAll(pageable));
        }catch (Exception e){
            logger.error("未知错误",e);
            return error("服务器内部异常");
        }

    }

    @GetMapping("/printcolor/{printcolorId}")
    public Result printcolor(@PathVariable("printcolorId")String printcolorId){
        try {
            return success(printColorService.findOne(Integer.valueOf(printcolorId)));
        }catch (Exception e){
            logger.error("未知错误",e);
            return error("服务器内部异常");
        }

    }

}
