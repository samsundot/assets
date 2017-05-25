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
            JSONObject parse = JsonUtil.parse(requestBody);
            String assetTypeId = (String)JsonUtil.getObject(parse, "assetTypeId");
            String costCenterId = (String) JsonUtil.getObject(parse, "costCenterId");
            String financialId = (String) JsonUtil.getObject(parse, "financialId");
            String locationId = (String) JsonUtil.getObject(parse, "locationId");
            String normsId = (String) JsonUtil.getObject(parse, "normsId");
            String procurementId = (String) JsonUtil.getObject(parse, "procurementId");
            String spaId = (String) JsonUtil.getObject(parse, "spaId");
            String assetId = (String)JsonUtil.getObject(parse, "assetId");
            String assetDesc = (String)JsonUtil.getObject(parse, "assetDesc");
            String assetName = (String)JsonUtil.getObject(parse, "assetName");





            AssetType assetType = new AssetType();
            assetType.setId(Integer.valueOf(assetTypeId));

            CostCenter costCenter = new CostCenter();
            costCenter.setId(Integer.valueOf(costCenterId));

            Financial financial = new Financial();
            financial.setId(Integer.valueOf(financialId));

            Location location = new Location();
            location.setId(Integer.valueOf(locationId));

            Norms norms = new Norms();
            norms.setId(Integer.valueOf(normsId));
            Procurement procurement = new Procurement();
            procurement.setId(Integer.valueOf(procurementId));


            Asset asset = new Asset();
            asset.setAssetId(assetId);
            asset.setNorms(norms);
            asset.setProcurement(procurement);
            asset.setLocation(location);
            asset.setFinancial(financial);
            asset.setAssetType(assetType);
            asset.setCostCenter(costCenter);
            asset.setAssetName(assetName);
            asset.setAssetDesc(assetDesc);
            asset.setCreateTime(Const.TIMESTAMP);
            asset.setSpaId(spaId);
            asset.setUpdateTime(Const.TIMESTAMP);



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
            String assetTypeId = (String)JsonUtil.getObject(parse, "assetTypeId");
            String costCenterId = (String) JsonUtil.getObject(parse, "costCenterId");
            String financialId = (String) JsonUtil.getObject(parse, "financialId");
            String locationId = (String) JsonUtil.getObject(parse, "locationId");
            String normsId = (String) JsonUtil.getObject(parse, "normsId");
            String procurementId = (String) JsonUtil.getObject(parse, "procurementId");
            String spaId = (String) JsonUtil.getObject(parse, "spaId");
            String assetDesc = (String)JsonUtil.getObject(parse, "assetDesc");
            String assetName = (String)JsonUtil.getObject(parse, "assetName");

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

    @GetMapping("test")
    public void test(){
        assetService.test();
    }


}
