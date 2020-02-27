package com.cn.yjrc.feignClent;

import com.cn.yjrc.domain.dto.ProcessingInfo;
import com.yg.learn.common.core.basic.ResponseResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author zjdking
 * 2020/2/26 0026.
 * @version 1.0
 */

@FeignClient(value = "PROCESSING-INFORMATION-GATHER-SERVICE")

public interface MyFeignClient {
    @GetMapping("/processingInformationGather/{key}")
    @ApiOperation(value="通过用户证件号码获取用户在办业务信息",notes = "key 默认只有1可以查出来信息")
    public ResponseResult<List<ProcessingInfo>> getProcessingInfo(@PathVariable String key);
}
