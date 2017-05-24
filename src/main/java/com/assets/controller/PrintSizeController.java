package com.assets.controller;

import com.alibaba.fastjson.JSONObject;
import com.assets.core.controller.BaseController;
import com.assets.core.util.JsonUtil;
import com.assets.core.util.Result;
import com.assets.entity.PrintSize;
import com.assets.service.PrintSizeService;
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
public class PrintSizeController extends BaseController{
    private static final Logger logger = LoggerFactory.getLogger(PrintSizeController.class);
    @Autowired
    PrintSizeService printSizeService;
    @PostMapping("/printsize")
    public Result addPrintSize(@RequestBody String requestBody){
        try {
            JSONObject parse = JsonUtil.parse(requestBody);
            String name = (String)JsonUtil.getObject(parse, "printsizeName");
            PrintSize printSize = new PrintSize(name);
            printSizeService.addPrintSize(printSize);
            return success("添加成功");
        }catch (Exception e){
            logger.error("未知错误",e);
            return error("服务器内部异常");
        }
    }

    @DeleteMapping("/printsize/{printsizeId}")
    public Result printsizeList(@PathVariable("printsizeId")String printsizeId){
        try {
            printSizeService.delPrintSize(Integer.valueOf(printsizeId));
            return success("删除成功");
        }catch (Exception e){
            e.printStackTrace();
            logger.error("未知错误",e);
            return error("服务器内部异常");
        }

    }

    @PutMapping("/printsize/{printsizeId}")
    public Result updatePrintSize(@PathVariable("printsizeId")String printsizeId,@RequestBody String requestBody){
        try {
            JSONObject parse = JsonUtil.parse(requestBody);
            String name = (String)JsonUtil.getObject(parse, "printsizeName");
            PrintSize printSize= new PrintSize();
            printSize.setId(Integer.valueOf(printsizeId));
            printSize.setName(name);
            boolean b = printSizeService.updatePrintSize(printSize);
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

    @GetMapping("/printsize")
    public Result printsizeList(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                    @RequestParam(value = "size", defaultValue = "30") Integer size){
        try {
            Sort sort = new Sort(Sort.Direction.DESC, "id");
            Pageable pageable = new PageRequest(page-1, size, sort);
            //查询所有
            return success(printSizeService.findAll(pageable));
        }catch (Exception e){
            logger.error("未知错误",e);
            return error("服务器内部异常");
        }

    }

    @GetMapping("/printsize/{printsizeId}")
    public Result printsize(@PathVariable("printsizeId")String printsizeId){
        try {
            return success(printSizeService.findOne(Integer.valueOf(printsizeId)));
        }catch (Exception e){
            logger.error("未知错误",e);
            return error("服务器内部异常");
        }

    }

}
