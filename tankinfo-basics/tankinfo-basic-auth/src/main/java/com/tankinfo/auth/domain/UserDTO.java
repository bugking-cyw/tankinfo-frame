package com.tankinfo.auth.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @Company: TANKINFO 坦克信息
 * @Author: Mr.cyw
 * @Machine: chenyawen
 * @Date: 2020/9/28 9:56 上午
 * @Description: Please Write notes scientifically
 */

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
public class UserDTO {

    private Long id;
    private String username;
    private String password;
    private Integer status;
    private List<String> roles;
}
