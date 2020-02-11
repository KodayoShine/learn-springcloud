package com.yg.learn.controller;

import cn.hutool.http.HttpStatus;
import com.yg.learn.api.dto.o.UserOutDTO;
import com.yg.learn.common.core.basic.ResponseResult;
import com.yg.learn.common.core.basic.ResponseResultManager;
import com.yg.learn.domain.User;
import com.yg.learn.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseResult<UserOutDTO> getUser(@PathVariable Long id) {
        UserOutDTO user = userService.getDataSourceUser(id);
        if(user == null){
            return ResponseResultManager.setResultError(HttpStatus.HTTP_NOT_FOUND, String.format("ID输入错误 %s", id));
        }
        LOGGER.info("根据id获取用户信息，用户名称为：{}", user.getUsername());
        return ResponseResultManager.setResultSuccess(user);
    }


}
