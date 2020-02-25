package com.yg.learn.controller;

import cn.hutool.http.HttpStatus;
import com.yg.learn.api.client.UnitServiceClient;
import com.yg.learn.api.dto.UnitInfoDTO;
import com.yg.learn.common.core.basic.ResponseResult;
import com.yg.learn.common.core.basic.ResponseResultManager;
import com.yg.learn.dto.PlatformDTO;
import com.yg.learn.service.PlatformService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


    /*   @GetMapping("/async")
      public ResponseResult<Long> async() {
           long start = System.currentTimeMillis();
           String msg = platformService.async();
           long end = System.currentTimeMillis();
          return ResponseResultManager.setResult(HttpStatus.HTTP_OK,msg,end - start);
      }*/
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


}

