package com.tankinfo.common.response.base;

import com.tankinfo.common.response.constants.ResConstants;
import lombok.Data;

/**
 * @Company: TANKINFO 坦克信息
 * @Author: Mr.cyw
 * @Machine: chenyawen
 * @Date: 2020/9/7 3:36 下午
 * @Description: Please Write notes scientifically
 */

@Data
public class BaseApiService<T> {

    public BaseResponse<T> setResultError(Integer code, String msg) {
        return setResult(code, msg, null);
    }

    /**
     * 返回错误，可以传msg
     *
     * @param msg
     * @return
     */
    public BaseResponse<T> setResultError(String msg) {
        return setResult(ResConstants.HTTP_RES_CODE_500, msg, null);
    }

    /***
     * 返回成功，可以传data值
     * @param data
     * @return
     */
    public BaseResponse<T> setResultSuccess(T data) {
        return setResult(ResConstants.HTTP_RES_CODE_200, ResConstants.HTTP_RES_CODE_200_VALUE, data);
    }

    /**
     * 返回成功，沒有data值
     *
     * @return
     */
    public BaseResponse<T> setResultSuccess() {
        return setResult(ResConstants.HTTP_RES_CODE_200, ResConstants.HTTP_RES_CODE_200_VALUE, null);
    }


    /**
     * 通用封装 通用封装
     *
     * @param code
     * @param msg
     * @param data
     * @return
     */

    public BaseResponse<T> setResult(Integer code, String msg, T data) {
        return new BaseResponse<T>(code, msg, data);
    }



    public BaseResponse<T> setResultDb(int dbCount, T successMsg, String errorMsg) {
        return dbCount > 0 ? setResultSuccess(successMsg) :
                setResultError(errorMsg);
    }


    /**
     * 未登录返回结果
     */
    public BaseResponse<T> unauthorized(String message) {
        return setResultError(401,"未授权 登录失败:"+message);
    }

    /**
     * 未授权返回结果
     */
    public BaseResponse<T> forbidden(String message) {
        return setResultError(403,"ACL禁止访问资源:"+message);
    }
}
