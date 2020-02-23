package com.yg.learn.api.client.fallback;

import com.yg.learn.api.client.EurekaUserClient;
import org.springframework.stereotype.Component;

@Component
public class EurekaUserFallbackClient implements EurekaUserClient {
    @Override
    public Object getUser(Long id) {
        return "eureka fallback";
    }
}
