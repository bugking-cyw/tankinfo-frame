package com.tankinfo.auth.doc;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import com.google.common.collect.Lists;
import com.tankinfo.common.knife4j.Knife4jconfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

/**
 * @Company: TANKINFO 坦克信息
 * @Author: Mr.cyw
 * @Machine: chenyawen
 * @Date: 2020/9/27 3:33 下午
 * @Description: Please Write notes scientifically
 */
@Component
public class ApiInfoServiceImp extends Knife4jconfig {

    final private static String baseApiPackage = "com.tankinfo.auth.imp.service";



    @Override
    protected ApiInfo groupApiInfo() {
        return new ApiInfoBuilder()
                .title("权限管理服务")
                .description("<div style='font-size:14px;color:red;'>权限管理服务</div>")
                .termsOfServiceUrl("http://tankinfo.com")
                .contact("bugking.chenyw@foxmail.com")
                .version("1.0")
                .build();
    }

    @Override
    protected String backagePath() {
        return baseApiPackage;
    }
}