package com.yg.learn.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.core.Ordered;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Slf4j
public class CustomizeFilter implements GatewayFilter, Ordered {


    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        System.out.println("进入自定义过滤器");
        log.info("----------------------------------------------------");
        return chain.filter(exchange);
    }

    /**
     * 过滤器设定优先级别的，值越大则优先级越低
     *
     * @return
     */
    @Override
    public int getOrder() {
        return 0;
    }
}
