package com.assets.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.assets.core.controller.BaseController;
import com.assets.core.util.JsonUtil;
import com.assets.core.util.Result;
import com.assets.entity.AssetType;
import com.assets.entity.Location;
import com.assets.service.AssetService;
import com.assets.service.AssetTypeService;
import com.assets.service.LocationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by hch on 2017/5/22.
 */
@RestController
public class LocationController extends BaseController{
    private static final Logger logger = LoggerFactory.getLogger(LocationController.class);
    @Autowired
    LocationService locationService;
    @Autowired
    AssetService assetService;

    @PostMapping("/location")
    public Result addLocaltion(@RequestBody String requestBody){
        try {
            JSONObject parse = JsonUtil.parse(requestBody);
            String pid = (String)JsonUtil.getObject(parse, "pid");
            String locationName = (String)JsonUtil.getObject(parse, "locationName");
            String detailedAddress = (String)JsonUtil.getObject(parse, "detailedAddress");
            String locationLevel = (String)JsonUtil.getObject(parse, "locationLevel");
            Location location = new Location();
            location.setLocationName(locationName);
            location.setDetailedAddress(detailedAddress);
            location.setLocationLevel(locationLevel);

            if(!StringUtils.isEmpty(pid.trim())){
                Location parent = new Location();
                parent.setId(Integer.valueOf(pid));
                location.setLocationParent(parent);

            }
            locationService.addLocation(location);
            return success("添加成功");
        }catch (Exception e){
            logger.error("未知错误",e);
            return error("服务器内部异常");
        }
    }


//    级联删除子分类，并解除资产表关联关系，不对资产做删除
    @DeleteMapping("/location/{locationId}")
    public Result locationList(@PathVariable("locationId")String locationId){
        try {
            assetService.updateLocationId(null,Integer.valueOf(locationId));
            locationService.delLocation(Integer.valueOf(locationId));
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
    @GetMapping("/localtion")
    public Result localtionList(){
        try {
            JSONArray results = new JSONArray();
            //查询一级菜单
            List<Location> byLocationLevel = locationService.findByLocationLevel("1");
            byLocationLevel.forEach(c->{
                results.add(JsonUtil.toJsonObj(c));
            });
            return success(results);
        }catch (Exception e){
            logger.error("未知错误",e);
            return error("服务器内部异常");
        }

    }
//    查下子级菜单
    @GetMapping("/localtion/{pid}")
    public Result localtion(@PathVariable("pid")String pid){
        try {
            JSONArray results = new JSONArray();
            List<Location> byParentId = locationService.findByParentId(Integer.valueOf(pid));
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
