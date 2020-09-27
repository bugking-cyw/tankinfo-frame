package com.tankinfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Company: TANKINFO 坦克信息
 * @Author: Mr.cyw
 * @Machine: chenyawen
 * @Date: 2020/9/7 2:37 下午
 * @Description: Please Write notes scientifically
 */

@SpringBootApplication
@EnableFeignClients
public class AppReceivable {

    public static void main(String[] args) {
        SpringApplication.run(AppReceivable.class);
    }
}
