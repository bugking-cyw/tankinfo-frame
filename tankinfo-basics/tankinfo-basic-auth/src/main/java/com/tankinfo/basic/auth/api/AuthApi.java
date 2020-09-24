package com.tankinfo.basic.auth.api;

import com.tankinfo.basic.auth.domain.TokenDTO;
import com.tankinfo.common.response.base.BaseResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.Map;

/**
 * @Company: TANKINFO 坦克信息
 * @Author: Mr.cyw
 * @Machine: chenyawen
 * @Date: 2020/9/24 10:26 上午
 * @Description: Please Write notes scientifically
 */
@Api(tags = "认证服务")
public interface AuthApi {

    @ApiOperation("获取公钥")
    @PostMapping("/oauth/token")
    public BaseResponse<TokenDTO> accessToken(Principal principal,@RequestParam Map<String, String> parameters) throws HttpRequestMethodNotSupportedException;
}
