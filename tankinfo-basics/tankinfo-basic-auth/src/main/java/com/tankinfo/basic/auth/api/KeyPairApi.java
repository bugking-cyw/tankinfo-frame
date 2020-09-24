package com.tankinfo.basic.auth.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

/**
 * @Company: TANKINFO 坦克信息
 * @Author: Mr.cyw
 * @Machine: chenyawen
 * @Date: 2020/9/23 5:55 下午
 * @Description: Please Write notes scientifically
 */

@Api(tags = "密钥服务")
public interface KeyPairApi {

    @ApiOperation("获取公钥")
    @GetMapping("/rsa/publicKey")
    public Map<String,Object> key();
}
