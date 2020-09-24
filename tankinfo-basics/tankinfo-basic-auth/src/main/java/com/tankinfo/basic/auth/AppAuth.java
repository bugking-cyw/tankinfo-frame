package com.tankinfo.basic.auth;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Company: TANKINFO 坦克信息
 * @Author: Mr.cyw
 * @Machine: chenyawen
 * @Date: 2020/9/23 5:28 下午
 * @Description: Please Write notes scientifically
 */
@EnableSwagger2Doc
@SpringBootApplication
public class AppAuth {

    public static void main(String[] args) {
        SpringApplication.run(AppAuth.class);
    }
}
