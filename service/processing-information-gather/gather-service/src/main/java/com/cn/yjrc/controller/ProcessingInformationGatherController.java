package com.cn.yjrc.controller;

import com.cn.yjrc.domain.ProcessingInfo;
import com.cn.yjrc.service.ProcessingInformationGatherService;
import com.yg.learn.common.core.basic.ResponseResult;
import com.yg.learn.common.core.basic.ResponseResultManager;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zjdking
 * 2020/2/25 0025.
 * @version 1.0
 */
@Api(tags = "GetherController", description = "获取全部人才服务在办业务信息")
@RestController
@RequestMapping(value = "/processingInformationGather")
public class ProcessingInformationGatherController {
    @Autowired
    ProcessingInformationGatherService getherService;

    @GetMapping("/{key}")
    @ApiOperation(value="通过用户证件号码获取用户在办业务信息",notes = "key 默认只有1可以查出来信息")
    public ResponseResult<List<ProcessingInfo>> getProcessingInfo(String key){
        List<ProcessingInfo> list = getherService.getProcessingInfo(key);
        return ResponseResultManager.setResultSuccess(list);
    }

    // 获取全部人才服务在办业务信息

}
