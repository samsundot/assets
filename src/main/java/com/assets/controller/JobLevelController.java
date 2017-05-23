package com.assets.controller;

import com.alibaba.fastjson.JSONObject;
import com.assets.core.constant.Const;
import com.assets.core.controller.BaseController;
import com.assets.core.util.JsonUtil;
import com.assets.core.util.Result;
import com.assets.entity.*;
import com.assets.service.AssetService;
import com.assets.service.JobLevelService;
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
public class JobLevelController extends BaseController{
    private static final Logger logger = LoggerFactory.getLogger(JobLevelController.class);
    @Autowired
    JobLevelService jobLevelService;


    @PostMapping("/jobLevel")
    public Result addJobLevel(@RequestBody String requestBody){
        try {
            JSONObject parse = JsonUtil.parse(requestBody);
            String description = (String)JsonUtil.getObject(parse, "description");
            String jobName = (String) JsonUtil.getObject(parse, "jobName");

            JobLevel jobLevel = new JobLevel(jobName,description);
            jobLevelService.addJobLevel(jobLevel);

            return success("添加成功");
        }catch (Exception e){
            logger.error("未知错误",e);
            return error("服务器内部异常");
        }
    }

    @DeleteMapping("/jobLevel/{jobLevelId}")
    public Result assetList(@PathVariable("jobLevelId")String jobLevelId){
        try {
            jobLevelService.delJobLevel(Integer.valueOf(jobLevelId));
            return success("删除成功");
        }catch (Exception e){
            e.printStackTrace();
            logger.error("未知错误",e);
            return error("服务器内部异常");
        }

    }

    @PutMapping("/jobLevel/{jobLevelId}")
    public Result updateAsset(@PathVariable("jobLevelId")String jobLevelId,@RequestBody String requestBody){
        try {
            JSONObject parse = JsonUtil.parse(requestBody);
            String description = (String)JsonUtil.getObject(parse, "description");
            String jobName = (String) JsonUtil.getObject(parse, "jobName");
            JobLevel jobLevel = new JobLevel();
            jobLevel.setDescription(description);
            jobLevel.setJobName(jobName);
            jobLevel.setId(Integer.valueOf(jobLevelId));

            boolean b = jobLevelService.updateJobLevel(jobLevel);
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

    @GetMapping("/jobLevel")
    public Result jobLevelList(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                    @RequestParam(value = "size", defaultValue = "30") Integer size){
        try {
            Sort sort = new Sort(Sort.Direction.DESC, "id");
            Pageable pageable = new PageRequest(page-1, size, sort);
            //查询所有
            return success(jobLevelService.findAll(pageable));
        }catch (Exception e){
            logger.error("未知错误",e);
            return error("服务器内部异常");
        }

    }

    @GetMapping("/jobLevel/{jobLevelId}")
    public Result jobLevel(@PathVariable("jobLevelId")String jobLevelId){
        try {
            return success(jobLevelService.findOne(Integer.valueOf(jobLevelId)));
        }catch (Exception e){
            logger.error("未知错误",e);
            return error("服务器内部异常");
        }

    }


}
