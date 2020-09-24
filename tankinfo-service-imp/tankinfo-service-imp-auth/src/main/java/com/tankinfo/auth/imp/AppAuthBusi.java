package com.tankinfo.auth.imp;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Company: TANKINFO 坦克信息
 * @Author: Mr.cyw
 * @Machine: chenyawen
 * @Date: 2020/9/4 6:04 下午
 * @Description: Please Write notes scientifically
 */
@SpringBootApplication
@EnableSwagger2Doc
/*@ComponentScan("com.tankinfo.*")*/
public class AppAuthBusi {

    public static void main(String[] args) {
        SpringApplication.run(AppAuthBusi.class);
    }
}
