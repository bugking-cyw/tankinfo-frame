package com.tankinfo.auth.api.service;


import com.tankinfo.auth.api.domain.dto.UserDto;
import com.tankinfo.auth.api.domain.vo.UserVo;
import com.tankinfo.common.response.base.BaseResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Api(tags = "权限基本服务接口")
public interface AuthService {

    @ApiOperation("获取当前用户信息")
    @GetMapping("/userInfo")
    BaseResponse<UserDto> userinfo();


    @ApiOperation("根据用户ID获取用户信息")
    @ApiImplicitParam(name = "userId", value = "用户ID" ,required = true)
    @GetMapping("/userInfoWithId")
    BaseResponse<UserDto> userInfo(@RequestParam("userId") String userId);


    @ApiOperation("根据用户ID新增用户信息")
    @ApiImplicitParam(name = "userId", value = "用户ID" ,required = true)
    @GetMapping("/user/add")
    BaseResponse add(@RequestParam("userId") String userId);

    @ApiOperation("更新用户信息")
    @PostMapping("/user/update")
    BaseResponse update(@RequestBody UserVo userVo);



}
