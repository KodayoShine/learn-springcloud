package com.yg.learn.controller;


import com.yg.learn.api.client.UserServiceClient;
import com.yg.learn.api.dto.o.UserOutDTO;
import com.yg.learn.common.core.basic.ResponseResult;
import com.yg.learn.common.core.basic.ResponseResultManager;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.WebAsyncTask;

import java.util.concurrent.Callable;

@Api(tags = "TestController", description = "测试管理")
@RestController
@RequestMapping("/test")
@AllArgsConstructor
public class TestController {

    private UserServiceClient userServiceClient;
   // private EurekaUserClient eurekaUserClient;

    @ApiOperation("获取用户信息")
    @GetMapping("/{id}")
    public ResponseResult<UserOutDTO> getUser(@PathVariable Long id) {
        ResponseResult<UserOutDTO> user = userServiceClient.getUser(id);
        return user;
    }


    @GetMapping("/callable")
    public ResponseResult<String> getUser() throws Exception {
        Callable<String> callable = userServiceClient.callable();
        String call = callable.call();
        return ResponseResultManager.setResultSuccess(call);
    }



/*    @GetMapping("/webAsyncTask")
    public ResponseResult<String > webAsyncTask() throws Exception {
        WebAsyncTask<String> stringWebAsyncTask = userServiceClient.webAsyncTask();
        *//*Callable<?> callable = stringWebAsyncTask.getCallable();
        String call = (String) callable.call();*//*
        return
    }*/
/*

    @ApiOperation("eureka获取用户信息")
    @GetMapping("/eureka/{id}")
    public Object getEureka(@PathVariable Long id) {
        Object user = eurekaUserClient.getUser(id);
        return user;
    }
*/


}
