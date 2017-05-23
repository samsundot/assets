package com.assets.controller;

import com.alibaba.fastjson.JSONObject;
import com.assets.core.constant.Const;
import com.assets.core.controller.BaseController;
import com.assets.core.util.JsonUtil;
import com.assets.core.util.Result;
import com.assets.entity.*;
import com.assets.service.AssetService;
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
public class AssetController extends BaseController{
    private static final Logger logger = LoggerFactory.getLogger(AssetController.class);
    @Autowired
    AssetService assetService;


    @PostMapping("/asset")
    public Result addAsset(@RequestBody String requestBody){
        try {
//            JSONObject parse = JsonUtil.parse(requestBody);
//            String manufacturersName = (String)JsonUtil.getObject(parse, "manufacturersName");
//            String description = (String)JsonUtil.getObject(parse, "description");




            AssetType assetType = new AssetType();
            assetType.setId(1);

            CostCenter costCenter = new CostCenter();
            costCenter.setId(1);

            Financial financial = new Financial();
            financial.setId(1);

            Location location = new Location();
//            location.
//            asset.setLocation(location);
//            asset.setProcurement();
//            asset.setNorms();







            Asset asset = new Asset();
//            asset.setAssetId();
//            asset.setNorms();
//            asset.setProcurement();
//            asset.setLocation();
//            asset.setFinancial();
//            asset.setAssetType();
//            asset.setCostCenter();
//            asset.setAssetName();
//            asset.setAssetDesc();
//            asset.setCreateTime(Const.TIMESTAMP);
//            asset.setSpaId();
//            asset.setUpdateTime(Const.TIMESTAMP);



            assetService.addAsset(asset);
            return success("添加成功");
        }catch (Exception e){
            logger.error("未知错误",e);
            return error("服务器内部异常");
        }
    }

    @DeleteMapping("/asset/{assetId}")
    public Result assetList(@PathVariable("assetId")String assetId){
        try {
            assetService.delAsset(Integer.valueOf(assetId));
            return success("删除成功");
        }catch (Exception e){
            e.printStackTrace();
            logger.error("未知错误",e);
            return error("服务器内部异常");
        }

    }

    @PutMapping("/asset/{assetId}")
    public Result updateAsset(@PathVariable("assetId")String assetId,@RequestBody String requestBody){
        try {
            JSONObject parse = JsonUtil.parse(requestBody);
            String manufacturersName = (String)JsonUtil.getObject(parse, "manufacturersName");
            String description = (String)JsonUtil.getObject(parse, "description");
            Asset asset = new Asset();
            asset.setId(Integer.valueOf(assetId));

            boolean b = assetService.updateAsset(asset);
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

    @GetMapping("/asset")
    public Result assetList(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                    @RequestParam(value = "size", defaultValue = "30") Integer size){
        try {
            Sort sort = new Sort(Sort.Direction.DESC, "id");
            Pageable pageable = new PageRequest(page-1, size, sort);
            //查询所有
            return success(assetService.findAll(pageable));
        }catch (Exception e){
            logger.error("未知错误",e);
            return error("服务器内部异常");
        }

    }

    @GetMapping("/asset/{assetId}")
    public Result asset(@PathVariable("assetId")String assetId){
        try {
            return success(assetService.findOne(Integer.valueOf(assetId)));
        }catch (Exception e){
            logger.error("未知错误",e);
            return error("服务器内部异常");
        }

    }


}
