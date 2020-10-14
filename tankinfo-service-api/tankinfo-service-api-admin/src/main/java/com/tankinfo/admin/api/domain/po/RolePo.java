package com.tankinfo.admin.api.domain.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Company: TANKINFO 坦克信息
 * @Author: Mr.cyw
 * @Machine: chenyawen
 * @Date: 2020/10/14 10:02 上午
 * @Description: Please Write notes scientifically
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("role")
public class RolePo {

    private Long roleId;

    private String roleCode;

    private String roleName;

    private Long parentId;

    private String mark;
}
