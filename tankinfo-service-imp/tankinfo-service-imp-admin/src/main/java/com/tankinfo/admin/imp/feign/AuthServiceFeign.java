package com.tankinfo.admin.imp.feign;


import com.tankinfo.common.response.base.BaseResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.security.Principal;
import java.util.Map;

/**
 * @Company: TANKINFO 坦克信息
 * @Author: Mr.cyw
 * @Machine: chenyawen
 * @Date: 2020/10/14 10:30 上午
 * @Description: Please Write notes scientifically
 */
@FeignClient("tankinfo-basic-auth")
public interface AuthServiceFeign {

    @PostMapping("/oauth/token")
    BaseResponse token(@RequestParam Map<String, String> parameters) throws HttpRequestMethodNotSupportedException;
}