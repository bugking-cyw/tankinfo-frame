package com.tankinfo.receivable.api.domain.po;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Company: TANKINFO 坦克信息
 * @Author: Mr.cyw
 * @Machine: chenyawen
 * @Date: 2020/9/8 3:55 下午
 * @Description: Please Write notes scientifically
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@TableName(value = "account")
public class AccountPo {

    @TableId
    private String accountId;

    private String userId;

    private double total;

    private double paid;

    private double due;
}
