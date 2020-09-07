package com.tankinfo.common.response.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Company: TANKINFO 坦克信息
 * @Author: Mr.cyw
 * @Machine: chenyawen
 * @Date: 2020/9/7 3:37 下午
 * @Description: Please Write notes scientifically
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseResponse<T> {
    /**
     * 返回码
     */
    private Integer code;
    /**
     * 消息
     */
    private String msg;
    /**
     * 返回
     */
    private T data;
    // 分页

}
