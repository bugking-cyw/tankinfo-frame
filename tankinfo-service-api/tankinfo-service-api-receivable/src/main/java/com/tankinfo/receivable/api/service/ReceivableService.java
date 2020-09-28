package com.tankinfo.receivable.api.service;


import com.tankinfo.common.response.base.BaseResponse;
import com.tankinfo.receivable.api.domain.dto.ReceivableDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Api(tags = "应收账款服务")
public interface ReceivableService {

    @ApiOperation("根据用户id获取应收账款")
    @ApiImplicitParam(name = "userId", value = "用户ID" ,required = true)
    @PostMapping("/money")
    BaseResponse<ReceivableDto> money(@RequestParam("userId") String userId);


    @ApiOperation("新增账号")
    @ApiImplicitParam(name = "userId", value = "用户ID" ,required = true)
    @PostMapping("/add")
    BaseResponse add(@RequestParam("userId") String userId);


    @ApiOperation("更新账号")
    @ApiImplicitParam(name = "loginName", value = "登录账号" ,required = true)
    @PostMapping("/update")
    BaseResponse update(@RequestParam("loginName")String loginName);

    @ApiOperation("测试权限")
    @ApiImplicitParam(name = "loginName", value = "登录账号" ,required = true)
    @PostMapping("/test")
    BaseResponse test(@RequestParam("loginName")String loginName);
}
