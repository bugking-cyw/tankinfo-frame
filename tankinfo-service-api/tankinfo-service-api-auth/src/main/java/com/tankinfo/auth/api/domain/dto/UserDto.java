package com.tankinfo.auth.api.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @Company: TANKINFO 坦克信息
 * @Author: Mr.cyw
 * @Machine: chenyawen
 * @Date: 2020/9/7 3:57 下午
 * @Description: Please Write notes scientifically
 */

@Data
@AllArgsConstructor
public class UserDto {

    private String name;

    private String userId;

    private Integer age;

    private String position;
}
