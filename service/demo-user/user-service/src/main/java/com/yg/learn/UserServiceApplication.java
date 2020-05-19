package com.yg.learn;

import com.yg.learn.test.Cat;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableFeignClients
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableDiscoveryClient
public class UserServiceApplication {

    public static void main(String[] args) {
        //new BCryptPasswordEncoder().encode("capinfo");
        SpringApplication.run(UserServiceApplication.class, args);
    }

    @Bean
    public Cat getCat(){
        return new Cat();
    }

}
