package com.tankinfo.auth.imp.service;

import com.tankinfo.auth.api.domain.dto.UserDto;
import com.tankinfo.auth.api.service.AuthService;
import com.tankinfo.common.response.base.BaseApiService;
import com.tankinfo.common.response.base.BaseResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RestController;

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

    @Override
    public BaseResponse<UserDto> userInfo(String userId) {
        UserDto userDto = new UserDto(configinfo, "1", 30, "coder");
        return setResultSuccess(userDto);
    }
}
