package com.zl.awesome.feignclient;

import feign.Feign;
import feign.Param;
import org.springframework.context.annotation.Bean;

/*
 * 功能描述: <br>
 * 〈〉
 * @Param: 
 * @Return: 
 * @Author: ZL
 * @Date: 2019/12/25 16:08
 */
public class FeignConfiguration {
    @Bean
    public Feign.Builder feignBuilder() {
        return Feign.builder().requestInterceptor(requestTemplate -> requestTemplate.header("auth", "false"));
    }
}
