package com.assets.controller;

import com.alibaba.fastjson.JSONObject;
import com.assets.core.controller.BaseController;
import com.assets.core.util.JsonUtil;
import com.assets.core.util.Result;
import com.assets.entity.Supplier;
import com.assets.service.SupplierService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

/**
 * Created by hflyf on 2017/5/23.
 */
@RestController
public class SupplierContronller extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(AreaController.class);
    @Autowired
    SupplierService supplierService;
    @PostMapping("/supplier")
    public Result addSupplier(@RequestBody String requestBody) {
        try {
            JSONObject parse = JsonUtil.parse(requestBody);

            String supplierName = (String)JsonUtil.getObject(parse,"supplierName");
            String description= (String)JsonUtil.getObject(parse,"description");
            String supplierType= (String)JsonUtil.getObject(parse,"supplierType");
            Supplier supplier= new Supplier(supplierName,description,supplierType);
 supplierService.addSupplier(supplier);
            return success("添加成功");
        }catch (Exception e){
            logger.error("未知错误",e);
            return error("服务器内部异常");
        }
    }
    @DeleteMapping("/supplier/{supplierId}")
    public Result areaList(@PathVariable("supplierId")String supplierId){
        try {
            supplierService.delSupplier(Integer.valueOf(supplierId));
            return success("删除成功");
        }
        catch (Exception e){
            e.printStackTrace();
            logger.error("未知错误",e);
            return error("服务器内部异常");


        }
    }
    @PutMapping("/supplier/{supplierId}")
    public Result updateArea(@PathVariable("supplierId")String supplierId,@RequestBody String requestBody){
        try {
            JSONObject parse = JsonUtil.parse(requestBody);

            String supplierName = (String)JsonUtil.getObject(parse,"supplierName");
            String description= (String)JsonUtil.getObject(parse,"description");
            String supplierType= (String)JsonUtil.getObject(parse,"supplierType");
            Supplier supplier1=new Supplier();
            supplier1.setId(Integer.valueOf(supplierId));
            supplier1.setSupplierName(supplierName);
            supplier1.setDescription(description);
            supplier1.setSupplierType(supplierType);

            boolean b = supplierService.updateSupplier(supplier1);
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
    @GetMapping("/supplier")
    public Result manufacturersList(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                    @RequestParam(value = "size", defaultValue = "30") Integer size){
        try {
            Sort sort = new Sort(Sort.Direction.DESC, "id");
            Pageable pageable = new PageRequest(page-1, size, sort);
            //查询所有
            return success(supplierService.findAll(pageable));
        }catch (Exception e){
            logger.error("未知错误",e);
            return error("服务器内部异常");
        }

    }
    @GetMapping("/supplier/{supplierId}")
    public Result area(@PathVariable("supplierId")String supplierId){
        try {
            return success(supplierService.findone(Integer.valueOf(supplierId)));
        }catch (Exception e){
            logger.error("未知错误",e);
            return error("服务器内部异常");
        }

    }
}
