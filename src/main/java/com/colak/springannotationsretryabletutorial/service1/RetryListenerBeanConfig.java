package com.colak.springannotationsretryabletutorial.service1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RetryListenerBeanConfig {

    @Bean
    public MyRetryListenerBean myRetryListenerBean() {
        return new MyRetryListenerBean();
    }
}
