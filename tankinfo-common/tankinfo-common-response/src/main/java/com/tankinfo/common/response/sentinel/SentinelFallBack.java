package com.tankinfo.common.response.sentinel;

import com.tankinfo.common.response.base.BaseApiService;
import com.tankinfo.common.response.base.BaseResponse;

/**
 * @Company: TANKINFO 坦克信息
 * @Author: Mr.cyw
 * @Machine: chenyawen
 * @Date: 2020/9/8 9:36 上午
 * @Description: Please Write notes scientifically
 */
public class SentinelFallBack {

    final private static String overLoadMessage = "访问过于频繁 请稍后重试";

    public static BaseResponse fallBack(){
        BaseApiService<Object> service = new BaseApiService<>();
        return service.setResultError(overLoadMessage);
    }
}
