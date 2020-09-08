package com.tankinfo.auth.imp.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.tankinfo.auth.api.domain.dto.UserDto;
import com.tankinfo.auth.api.service.AuthService;
import com.tankinfo.common.response.base.BaseApiService;
import com.tankinfo.common.response.base.BaseResponse;
import com.tankinfo.common.response.sentinel.SentinelFallBack;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RestController;

import java.util.Timer;
import java.util.concurrent.TimeUnit;

/**
 * @Company: TANKINFO 坦克信息
 * @Author: Mr.cyw
 * @Machine: chenyawen
 * @Date: 2020/9/4 6:06 下午
 * @Description: Please Write notes scientifically
 */
@RestController
@RefreshScope
public class AuthServiceImp extends BaseApiService implements AuthService {

    @Value("${auth.configinfo}")
    private String configinfo;



    @Override
    public BaseResponse<UserDto> userinfo() {

        UserDto userDto = new UserDto(configinfo, "1", 30, "coder");
        return setResultSuccess(userDto);
    }

    @SentinelResource(value = "userinfobyid", fallbackClass = SentinelFallBack.class, defaultFallback = "fallBack")
    @Override
    public BaseResponse<UserDto> userInfo(String userId) {
        /*try{
            TimeUnit.MILLISECONDS.sleep(2000);
        }catch (Exception e){
            e.printStackTrace();
        }*/
        UserDto userDto = new UserDto(configinfo, "1", 30, "coder");
        return setResultSuccess(userDto);
    }
}
