package com.assets.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.assets.core.constant.Const;
import com.assets.core.controller.BaseController;
import com.assets.core.util.JsonUtil;
import com.assets.core.util.Result;
import com.assets.dao.AssetTypeDao;
import com.assets.entity.*;
import com.assets.service.AssetService;
import com.assets.service.AssetTypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

/**
 * Created by hch on 2017/5/22.
 */
@RestController
public class AssetTypeController extends BaseController{
    private static final Logger logger = LoggerFactory.getLogger(AssetTypeController.class);
    @Autowired
    AssetTypeService assetTypeService;
    @Autowired
    AssetService assetService;

    @PostMapping("/assetType")
    public Result addAssetType(@RequestBody String requestBody){
        try {
            JSONObject parse = JsonUtil.parse(requestBody);
            String pid = (String)JsonUtil.getObject(parse, "pid");
            String typeName = (String)JsonUtil.getObject(parse, "typeName");
            String description = (String)JsonUtil.getObject(parse, "description");
            String typeLevel = (String)JsonUtil.getObject(parse, "typeLevel");
            AssetType assetType = new AssetType();
            assetType.setAssetTypeName(typeName);
            assetType.setDescription(description);
            assetType.setAssetTypeLevel(typeLevel);
            if(!StringUtils.isEmpty(pid.trim())){
                AssetType parent = new AssetType();
                parent.setId(Integer.valueOf(pid));
                assetType.setAssetTypeParent(parent);
            }
            assetTypeService.addAssetType(assetType);
            return success("添加成功");
        }catch (Exception e){
            logger.error("未知错误",e);
            return error("服务器内部异常");
        }
    }


//    级联删除子分类，并解除资产表关联关系，不对资产做删除
    @DeleteMapping("/assetType/{assetTypeId}")
    public Result assetList(@PathVariable("assetTypeId")String assetTypeId){
        try {
            assetService.updateassetTypeId(null,Integer.valueOf(assetTypeId));
            assetTypeService.delAssetType(Integer.valueOf(assetTypeId));
            return success("删除成功");
        }catch (Exception e){
            e.printStackTrace();
            logger.error("未知错误",e);
            return error("服务器内部异常");
        }

    }
//
//    @PutMapping("/asset/{assetId}")
//    public Result updateAsset(@PathVariable("assetId")String assetId,@RequestBody String requestBody){
//        try {
//            JSONObject parse = JsonUtil.parse(requestBody);
//            String assetTypeId = (String)JsonUtil.getObject(parse, "assetTypeId");
//            String costCenterId = (String) JsonUtil.getObject(parse, "costCenterId");
//            String financialId = (String) JsonUtil.getObject(parse, "financialId");
//            String locationId = (String) JsonUtil.getObject(parse, "locationId");
//            String normsId = (String) JsonUtil.getObject(parse, "normsId");
//            String procurementId = (String) JsonUtil.getObject(parse, "procurementId");
//            String spaId = (String) JsonUtil.getObject(parse, "spaId");
//            String assetDesc = (String)JsonUtil.getObject(parse, "assetDesc");
//            String assetName = (String)JsonUtil.getObject(parse, "assetName");
//
//            Asset asset = new Asset();
//            asset.setId(Integer.valueOf(assetId));
//
//            boolean b = assetTypeService.updateAsset(asset);
//            if(b){
//                return success("修改成功");
//            }
//            return error("修改失败");
//        }catch (Exception e){
//            e.printStackTrace();
//            logger.error("未知错误",e);
//            return error("服务器内部异常");
//        }
//    }
//
    @GetMapping("/assetType")
    public Result assetTypeList(){
        try {
            JSONArray results = new JSONArray();
            //查询一级菜单
            List<AssetType> all = assetTypeService.findByAssetTypeLevel("1");
            all.forEach(c->{
                results.add(JsonUtil.toJsonObj(c));
            });
            return success(results);
        }catch (Exception e){
            logger.error("未知错误",e);
            return error("服务器内部异常");
        }

    }
//    查下子级菜单
    @GetMapping("/assetType/{pid}")
    public Result asset(@PathVariable("pid")String pid){
        try {
            JSONArray results = new JSONArray();
            List<AssetType> byParentId = assetTypeService.findByParentId(Integer.valueOf(pid));
            byParentId.forEach(c->{
                results.add(JsonUtil.toJsonObj(c));
            });
            return success(results);
        }catch (Exception e){
            logger.error("未知错误",e);
            return error("服务器内部异常");
        }

    }


}
