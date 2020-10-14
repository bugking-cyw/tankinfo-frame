package com.tankinfo.admin.doc;

import com.tankinfo.common.knife4j.Knife4jconfig;
import org.springframework.stereotype.Component;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.*;

/**
 * @Company: TANKINFO 坦克信息
 * @Author: Mr.cyw
 * @Machine: chenyawen
 * @Date: 2020/9/27 3:33 下午
 * @Description: Please Write notes scientifically
 */
@Component
public class ApiInfoServiceImp extends Knife4jconfig {

    final private static String baseApiPackage = "com.tankinfo.admin.imp.service";



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