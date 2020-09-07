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
}
