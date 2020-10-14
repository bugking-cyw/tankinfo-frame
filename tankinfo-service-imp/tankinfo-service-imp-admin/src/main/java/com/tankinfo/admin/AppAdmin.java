package com.tankinfo.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Company: TANKINFO 坦克信息
 * @Author: Mr.cyw
 * @Machine: chenyawen
 * @Date: 2020/9/4 6:04 下午
 * @Description: Please Write notes scientifically
 */
@EnableFeignClients
@SpringBootApplication
public class AppAdmin {

    public static void main(String[] args) {
        SpringApplication.run(AppAdmin.class);
    }
}
