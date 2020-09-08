package com.tankinfo.receivable.imp.service;


import com.tankinfo.auth.api.domain.dto.UserDto;
import com.tankinfo.common.response.base.BaseApiService;
import com.tankinfo.common.response.base.BaseResponse;
import com.tankinfo.common.response.constants.ResConstants;
import com.tankinfo.receivable.api.domain.dto.ReceivableDto;
import com.tankinfo.receivable.api.service.ReceivableService;
import com.tankinfo.receivable.imp.feign.AuthServiceFeign;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;


/**
 * @Company: TANKINFO 坦克信息
 * @Author: Mr.cyw
 * @Machine: chenyawen
 * @Date: 2020/9/7 2:38 下午
 * @Description: Please Write notes scientifically
 */
@RestController
public class ReceivableServiceImp extends BaseApiService implements ReceivableService {

    @Resource
    private AuthServiceFeign authServiceFeign;

    @Override
    public BaseResponse<ReceivableDto> money(String userId) {
        BaseResponse<UserDto> userResponse = authServiceFeign.userinfo();
        if (!ResConstants.HTTP_RES_CODE_200.equals(userResponse.getCode())){
            return setResultError(userResponse.getCode(), userResponse.getMsg());
        }
        Integer age = userResponse.getData().getAge();
        int money = age * 10000;
        ReceivableDto receivableDto = new ReceivableDto("pn", "cyw", 100000.0, 30000.0, 70000.0);
        return setResultSuccess(receivableDto);
    }
}
