package com.cn.yjrc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author zjdking
 * 2020/2/25 0025.
 * @version 1.0
 */
// 扫描feign注解
@EnableFeignClients
// 服务发现
@EnableDiscoveryClient
@SpringBootApplication
public class ProcessingInformationGather_App {
    public static void main(String[] args) {
        SpringApplication.run(ProcessingInformationGather_App.class,args);
    }
}
