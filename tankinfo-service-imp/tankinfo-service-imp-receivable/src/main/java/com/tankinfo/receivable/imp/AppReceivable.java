package com.tankinfo.receivable.imp;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Company: TANKINFO 坦克信息
 * @Author: Mr.cyw
 * @Machine: chenyawen
 * @Date: 2020/9/7 2:37 下午
 * @Description: Please Write notes scientifically
 */

@SpringBootApplication
@EnableSwagger2Doc
@EnableFeignClients
/*@ComponentScan("com.tankinfo.*")*/
public class AppReceivable {

    public static void main(String[] args) {
        SpringApplication.run(AppReceivable.class);
    }
}
