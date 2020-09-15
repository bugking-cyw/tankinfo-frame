package com.tankinfo.auth.api.domain.dto;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

/**
 * @Company: TANKINFO 坦克信息
 * @Author: Mr.cyw
 * @Machine: chenyawen
 * @Date: 2020/9/7 3:57 下午
 * @Description: Please Write notes scientifically
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("user")
public class UserDto {

    private String userName;

    private String userId;

    private Integer age;

    private String postion;

    private String loginName;

    private String password;

    private boolean finished;
}
