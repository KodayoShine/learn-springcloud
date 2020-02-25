package com.droideye.config;

import com.alibaba.csp.sentinel.adapter.servlet.CommonFilter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean sentinelFilterRegistration() {
        FilterRegistrationBean<CommonFilter> registration = new FilterRegistrationBean<>();
        registration.setFilter(new CommonFilter());
        // Set the matching URL pattern for the filter.
        registration.addUrlPatterns("/*");
        registration.setName("sentinelCommonFilter");
        registration.setOrder(1);

        return registration;
    }
}