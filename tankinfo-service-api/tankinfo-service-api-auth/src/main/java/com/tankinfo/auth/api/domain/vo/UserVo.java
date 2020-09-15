package com.tankinfo.auth.api.domain.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Company: TANKINFO 坦克信息
 * @Author: Mr.cyw
 * @Machine: chenyawen
 * @Date: 2020/9/14 5:20 下午
 * @Description: Please Write notes scientifically
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserVo {


    @ApiModelProperty(value = "登录账号", required = true)
    private String loginName;

    @ApiModelProperty(value = "密码", required = true)
    private String password;
}
