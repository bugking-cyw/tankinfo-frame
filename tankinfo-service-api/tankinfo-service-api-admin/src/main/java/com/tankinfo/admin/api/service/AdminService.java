package com.tankinfo.admin.api.service;

import com.tankinfo.admin.api.domain.dto.LoginReguestDto;
import com.tankinfo.common.response.base.BaseResponse;
import com.tankinfo.system.auth.UserDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import springfox.documentation.annotations.ApiIgnore;

import java.security.Principal;

/**
 * @Company: TANKINFO 坦克信息
 * @Author: Mr.cyw
 * @Machine: chenyawen
 * @Date: 2020/10/12 5:49 下午
 * @Description: Please Write notes scientifically
 */
@Api(tags = "后台管理服务")
@RequestMapping("/admin")
public interface AdminService {

    @ApiOperation("登录")
    @PostMapping("/login")
    BaseResponse login( @Validated @RequestBody LoginReguestDto loginReguestDto) throws Exception;


    @ApiOperation("名称加载用户")
    @PostMapping("/loadUserByName")
    UserDto loadUserByName(@RequestParam String userName);


    @ApiOperation("当前用户信息")
    @PostMapping("/currentUser")
    BaseResponse currentUser();

    @ApiOperation("登出")
    @PostMapping("/logout")
    BaseResponse logout();
}
