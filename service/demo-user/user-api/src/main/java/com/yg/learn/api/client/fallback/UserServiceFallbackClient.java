package com.yg.learn.api.client.fallback;

import cn.hutool.http.HttpStatus;
import com.yg.learn.api.client.UserServiceClient;
import com.yg.learn.api.dto.o.UserOutDTO;
import com.yg.learn.common.core.basic.ResponseResult;
import com.yg.learn.common.core.basic.ResponseResultManager;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
public class UserServiceFallbackClient implements UserServiceClient {
    @Override
    public ResponseResult<UserOutDTO> getUser(Long id) {
        return ResponseResultManager.setResultError(HttpStatus.HTTP_NOT_FOUND, "服务降级返回");
    }

    @Override
    public CompletableFuture<String> async() {
        return CompletableFuture.supplyAsync(()->{
            return "async error";
        });
    }

    @Override
    public String sync() {
        return "sync error";
    }
}
