package com.tankinfo.admin.api.domain.vo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("user")
public class UserVo {

    @TableId
    private String userId;

    private String loginName;

    private String password;

    private String userName;

    private Long createTime;

    private String from;

    private String creator;

    private Long limitTime;

    private Long validTime;

    private Boolean isValid;


}
