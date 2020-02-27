package com.yg.learn.controller;

import cn.hutool.http.HttpStatus;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.yg.learn.api.client.UnitServiceClient;
import com.yg.learn.api.dto.UnitInfoDTO;
import com.yg.learn.api.dto.o.UserOutDTO;
import com.yg.learn.common.core.basic.ResponseResult;
import com.yg.learn.common.core.basic.ResponseResultManager;
import com.yg.learn.dto.OverviewInfoDTO;
import com.yg.learn.dto.PlatformDTO;
import com.yg.learn.dto.o.OverviewEnterDTO;
import com.yg.learn.service.PlatformService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/platform")
@Slf4j
public class PlatformController {

    @Autowired
    private PlatformService platformService;

    @GetMapping("/{id}")
    public ResponseResult<PlatformDTO> getUser(@PathVariable Long id) {
        PlatformDTO platformDTO = platformService.getAllData(id);
        log.info("测试11111----,{}", platformDTO.toString());
        return ResponseResultManager.setResultSuccess(platformDTO);
    }

    @GetMapping("/sync")
    public ResponseResult<Long> sync() throws ExecutionException, InterruptedException {
        String msg = platformService.sync();
        return ResponseResultManager.setResult(HttpStatus.HTTP_OK, msg, 1L);
    }

    @GetMapping("/async")
    public ResponseResult<Long> async() throws ExecutionException, InterruptedException {
        String msg = platformService.async();
        return ResponseResultManager.setResult(HttpStatus.HTTP_OK, msg, 1L);
    }


    @GetMapping("/userasync")
    public ResponseResult<Long> userasync() throws ExecutionException, InterruptedException {
        String msg = platformService.userasync();
        return ResponseResultManager.setResult(HttpStatus.HTTP_OK, msg, 1L);
    }

    @PostMapping("/getOverviewInfo")
    @SentinelResource(value = "byResource",blockHandler = "handleException")
    public ResponseResult<OverviewInfoDTO> getOverviewInfo(@RequestBody OverviewEnterDTO overviewEnterDTO, HttpServletRequest request)  {
        String header = request.getHeader("Authorization");
        if(header == null || !"123123".equals(header)){
            return ResponseResultManager.setResult(HttpStatus.HTTP_UNAUTHORIZED,"权限不足",null);
        }
        OverviewInfoDTO overviewInfo = platformService.getOverviewInfo(overviewEnterDTO.getSfzh());
        return ResponseResultManager.setResultSuccess(overviewInfo);
    }

    /**
     * 这里必须根据byResource进行资源限流,根据url限流无法显示该信息
     * @param exception
     * @return
     */
    public ResponseResult<UserOutDTO> handleException(BlockException exception){
        return ResponseResultManager.setResultError(HttpStatus.HTTP_CLIENT_TIMEOUT, "");
    }





}

