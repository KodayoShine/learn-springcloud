package com.yg.learn.controller;

import cn.hutool.http.HttpStatus;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.yg.learn.api.dto.o.UserOutDTO;
import com.yg.learn.common.core.basic.ResponseResult;
import com.yg.learn.common.core.basic.ResponseResultManager;
import com.yg.learn.domain.User;
import com.yg.learn.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RefreshScope
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

    @GetMapping("/sentinel")
    @SentinelResource(value = "byResource",blockHandler = "handleException")
    public ResponseResult<UserOutDTO> getSentinelUser() {
        UserOutDTO user = userService.getDataSourceUser(1L);
        if(user == null){
            return ResponseResultManager.setResultError(HttpStatus.HTTP_NOT_FOUND, String.format("1有问题"));
        }
        LOGGER.info("根据id获取用户信息，用户名称为：{}", user.getUsername());
        return ResponseResultManager.setResultSuccess(user);
    }

    /**
     * 这里必须根据byResource进行资源限流,根据url限流无法显示该信息
     * @param exception
     * @return
     */
    public ResponseResult<UserOutDTO> handleException(BlockException exception){
        return ResponseResultManager.setResultError(HttpStatus.HTTP_NOT_FOUND, String.format("限流"));
    }

    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/configInfo")
    public String getConfigInfo() {
        return configInfo;
    }


}
