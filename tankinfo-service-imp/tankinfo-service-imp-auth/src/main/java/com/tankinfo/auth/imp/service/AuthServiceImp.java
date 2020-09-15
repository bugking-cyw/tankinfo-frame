package com.tankinfo.auth.imp.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tankinfo.auth.api.domain.dto.UserDto;
import com.tankinfo.auth.api.domain.vo.UserVo;
import com.tankinfo.auth.api.service.AuthService;
import com.tankinfo.auth.imp.mapper.UserMapper;
import com.tankinfo.common.response.base.BaseApiService;
import com.tankinfo.common.response.base.BaseResponse;
import com.tankinfo.common.response.sentinel.SentinelFallBack;
import com.tankinfo.common.utils.IdUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
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


    @Resource
    private UserMapper userMapper;



    @Override
    public BaseResponse<UserDto> userinfo() {

        UserDto userDto = new UserDto(configinfo, "1", 30, "coder", "cyw", "000000", false);
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
        UserDto userDto = new UserDto(configinfo, "1", 30, "coder", "cyw", "password", true);
        return setResultSuccess(userDto);
    }


    @Override
    public BaseResponse add(String userId) {
        UserDto userDto = new UserDto(configinfo, IdUtils.uuid(), 31, "mp", "cyw", "password", true);
        userMapper.insert(userDto);
        return setResultSuccess();
    }

    @Transactional
    @Override
    public BaseResponse update(UserVo userVo) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("login_name", userVo.getLoginName());
        queryWrapper.eq("password", userVo.getPassword());
        userMapper.update(new UserDto(){{setFinished(false);}}, queryWrapper);
        return setResultSuccess();
    }
}
