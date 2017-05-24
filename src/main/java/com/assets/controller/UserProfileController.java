package com.assets.controller;

import com.alibaba.fastjson.JSONObject;
import com.assets.core.controller.BaseController;
import com.assets.core.util.JsonUtil;
import com.assets.core.util.Result;
import com.assets.entity.*;
import com.assets.service.UserProfileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 2017/5/24 0024.
 */
@RestController
public class UserProfileController extends BaseController{
    @Autowired
    UserProfileService userProfileService;
    private static final Logger logger = LoggerFactory.getLogger(AssetController.class);
    //新增
    @PostMapping("/addUserProfile")
    public Result addUserProfile(@RequestBody String requestBody){
        try {
            JSONObject jsonObject = JsonUtil.parse(requestBody);
            String username = (String) JsonUtil.getObject(jsonObject,"username");
            String jobLevelId = (String)JsonUtil.getObject(jsonObject,"jobLevelId");//职位
            String officePhone = (String)JsonUtil.getObject(jsonObject,"officePhone");
            String primaryPhone = (String)JsonUtil.getObject(jsonObject,"primaryPhone");
            String mobilePhone = (String)JsonUtil.getObject(jsonObject,"mobilePhone");
            String departmentId = (String)JsonUtil.getObject(jsonObject,"departmentId");//部门
            String constCenterId = (String)JsonUtil.getObject(jsonObject,"constCenterId");//成本中心
            String manager = (String)JsonUtil.getObject(jsonObject,"manager");
            String note = (String)JsonUtil.getObject(jsonObject,"note");

            JobLevel jobLevel = new JobLevel();
            jobLevel.setId(Integer.valueOf(jobLevelId));
            Department department = new Department();
            department.setId(Integer.valueOf(departmentId));
            CostCenter costCenter = new CostCenter();
            costCenter.setId(Integer.valueOf(constCenterId));

            UserProfile userProfile = new UserProfile();
            userProfile.setUsername(username);
            userProfile.setJobLevel(jobLevel);
            userProfile.setOfficePhone(officePhone);
            userProfile.setPrimaryPhone(primaryPhone);
            userProfile.setMobilePhone(mobilePhone);
            userProfile.setDepartment(department);
            userProfile.setCostCenter(costCenter);
            userProfile.setManager(manager);
            userProfile.setNote(note);
            userProfileService.addUserProfile(userProfile);
            return success("添加成功！");
        }catch (Exception e){
            logger.error("未知错误",e);
            return error("服务器内部异常");
        }
    }
    //删除
    @DeleteMapping("/deleteUserProfile/{id}")
    public Result deleteUserProfile(@PathVariable("id")String id){
        try {
            userProfileService.deleteUserProfile(Integer.valueOf(id));
            return success("删除成功");
        }catch (Exception e){
            e.printStackTrace();
            logger.error("未知错误",e);
            return error("服务器内部异常");
        }

    }
    //修改
    @PutMapping("/updateUserProfile/{id}")
    public Result updateUserProfile(@PathVariable("id")String id,@RequestBody String requestBody){
        try {
            JSONObject jsonObject = JsonUtil.parse(requestBody);
            String username = (String) JsonUtil.getObject(jsonObject,"username");
            String jobLevelId = (String)JsonUtil.getObject(jsonObject,"jobLevelId");//职位
            String officePhone = (String)JsonUtil.getObject(jsonObject,"officePhone");
            String primaryPhone = (String)JsonUtil.getObject(jsonObject,"primaryPhone");
            String mobilePhone = (String)JsonUtil.getObject(jsonObject,"mobilePhone");
            String departmentId = (String)JsonUtil.getObject(jsonObject,"departmentId");//部门
            String constCenterId = (String)JsonUtil.getObject(jsonObject,"constCenterId");//成本中心
            String manager = (String)JsonUtil.getObject(jsonObject,"manager");
            String note = (String)JsonUtil.getObject(jsonObject,"note");

            JobLevel jobLevel = new JobLevel();
            jobLevel.setId(Integer.valueOf(jobLevelId));
            Department department = new Department();
            department.setId(Integer.valueOf(departmentId));
            CostCenter costCenter = new CostCenter();
            costCenter.setId(Integer.valueOf(constCenterId));

            UserProfile userProfile = new UserProfile();
            userProfile.setId(Integer.valueOf(id));
            userProfile.setUsername(username);
            userProfile.setJobLevel(jobLevel);
            userProfile.setOfficePhone(officePhone);
            userProfile.setPrimaryPhone(primaryPhone);
            userProfile.setMobilePhone(mobilePhone);
            userProfile.setDepartment(department);
            userProfile.setCostCenter(costCenter);
            userProfile.setManager(manager);
            userProfile.setNote(note);
            boolean b = userProfileService.updateUserProfile(userProfile);
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

    @GetMapping("/userProfile")
    public Result userProfileList(@RequestParam(value = "page", defaultValue = "1") Integer page,
                           @RequestParam(value = "size", defaultValue = "30") Integer size){
        try {
            Sort sort = new Sort(Sort.Direction.DESC, "id");
            Pageable pageable = new PageRequest(page-1, size, sort);
            //查询所有
            return success(userProfileService.findAll(pageable));
        }catch (Exception e){
            logger.error("未知错误",e);
            return error("服务器内部异常");
        }

    }

    @GetMapping("/userProfileById/{id}")
    public Result userProfileById(@PathVariable("id")String id) {
        try {
            UserProfile one = userProfileService.findOne(Integer.valueOf(id));
            return success(userProfileService.findOne(Integer.valueOf(id)));

        } catch (Exception e) {
            logger.error("未知错误", e);
            return error("服务器内部异常");
        }

    }
}
