package com.yg.learn.service;

import com.yg.learn.api.client.UnitServiceClient;
import com.yg.learn.api.client.UserServiceClient;
import com.yg.learn.api.dto.UnitInfoDTO;
import com.yg.learn.api.dto.o.UserOutDTO;
import com.yg.learn.common.core.basic.ResponseResult;
import com.yg.learn.dto.PlatformDTO;
import lombok.AllArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

@Service
@AllArgsConstructor
public class PlatformService {

    private final UserServiceClient userServiceClient;
    private final UnitServiceClient unitServiceClient;


    public PlatformDTO getAllData(Long id) {
        ResponseResult<UserOutDTO> user = userServiceClient.getUser(id);
        ResponseResult<UnitInfoDTO> unit = unitServiceClient.getUnit(id);

        // 进行封装
        PlatformDTO platformDTO = new PlatformDTO();
        platformDTO.setUnitInfoDTO(unit.getResult());
        platformDTO.setUserOutDTO(user.getResult());
        return platformDTO;
    }

    public String async() {
        long start = System.currentTimeMillis();
        userServiceClient.sync();
        unitServiceClient.sync();
        long end = System.currentTimeMillis();
        System.out.println("同步调用两个接口" + (end - start));
        return "ok";
    }

    public String sync() throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();
        System.out.println(start);
        CompletableFuture<String> result1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("userServiceClient======" + Thread.currentThread().getName());
            return userServiceClient.sync();
        });

        CompletableFuture<String> result2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("unitServiceClient======" + Thread.currentThread().getName());
            return unitServiceClient.sync();
        });

        long end1 = System.currentTimeMillis();
        System.out.println(end1);
        String s = result1.get();
        String s1 = result2.get();
        long end2 = System.currentTimeMillis();
        System.out.println("使用CompletableFuture分别调用两个接口: " + (end2 - end1));
        return s + s1;
    }
}
