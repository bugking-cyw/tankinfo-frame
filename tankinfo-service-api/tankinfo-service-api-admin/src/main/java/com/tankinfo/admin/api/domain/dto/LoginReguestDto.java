package com.tankinfo.admin.api.domain.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotEmpty;

/**
 * @Company: TANKINFO 坦克信息
 * @Author: Mr.cyw
 * @Machine: chenyawen
 * @Date: 2020/10/12 5:56 下午
 * @Description: Please Write notes scientifically
 */
@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class LoginReguestDto {

    @NotEmpty
    @ApiModelProperty(value = "用户名", required = true)
    private String loginName;
    @NotEmpty
    @ApiModelProperty(value = "密码", required = true)
    private String password;

    @ApiModelProperty(value = "验证码", required = false)
    private String vaidateCode;

    @ApiModelProperty(value = "验证码key", required = false)
    private String validateKey;
}
