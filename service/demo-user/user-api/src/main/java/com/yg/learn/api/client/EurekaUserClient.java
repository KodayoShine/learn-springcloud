package com.yg.learn.api.client;

import com.yg.learn.api.client.fallback.EurekaUserFallbackClient;
import com.yg.learn.api.client.fallback.UserServiceFallbackClient;
import com.yg.learn.api.dto.o.UserOutDTO;
import com.yg.learn.common.core.basic.ResponseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name = "eureka-server-client",url = "${provider-url-eureka}", fallback = EurekaUserFallbackClient.class)
public interface EurekaUserClient {

    //@GetMapping("/user/{id}")
    public Object getUser(@PathVariable Long id) ;


}
