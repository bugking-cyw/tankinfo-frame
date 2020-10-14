package com.tankinfo.admin.api.domain.po;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Company: TANKINFO 坦克信息
 * @Author: Mr.cyw
 * @Machine: chenyawen
 * @Date: 2020/10/13 4:59 下午
 * @Description: Please Write notes scientifically
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("user")
public class UserPo {

    @TableId
    private Long userId;

    private String loginName;

    private String password;

    private String userName;

    private Long createTime;

    private String origin;

    private String creator;

    private Long limitTime;

    private Long validTime;

    private Boolean isValid;
}
