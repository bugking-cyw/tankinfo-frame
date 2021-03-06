package com.tankinfo.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Company: TANKINFO 坦克信息
 * @Author: Mr.cyw
 * @Machine: chenyawen
 * @Date: 2020/9/28 10:28 上午
 * @Description: Please Write notes scientifically
 */

@EnableCaching
@EnableFeignClients
@SpringBootApplication
public class AppAuth {

    public static void main(String[] args) {
        SpringApplication.run(AppAuth.class);
    }
}
