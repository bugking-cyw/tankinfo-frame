package com.tankinfo.auth.api.service;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;

@Api(tags = "权限基本服务接口")
public interface AuthService {

    @ApiOperation("获取当前用户信息")
    @GetMapping("/userInfo")
    String userinfo();


    @ApiOperation("根据用户ID获取用户信息")
    @ApiImplicitParam(name = "userId", value = "用户ID" ,required = true)
    @GetMapping("/userInfoWithId")
    String userInfo(String userId);
}
