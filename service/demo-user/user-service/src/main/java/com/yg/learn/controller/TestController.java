package com.yg.learn.controller;


import cn.hutool.http.HttpStatus;
import com.yg.learn.api.client.UserServiceClient;
import com.yg.learn.api.dto.o.UserOutDTO;
import com.yg.learn.common.core.basic.ResponseResult;
import com.yg.learn.common.core.basic.ResponseResultManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {


    private UserServiceClient userServiceClient;

    @Autowired
    public void setUserServiceClient(UserServiceClient userServiceClient) {
        this.userServiceClient = userServiceClient;
    }

    @GetMapping("/{id}")
    public ResponseResult<UserOutDTO> getUser(@PathVariable Long id) {
        ResponseResult<UserOutDTO> user = userServiceClient.getUser(id);
        return user;
    }

}
