package com.tankinfo.receivable.imp.service;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tankinfo.admin.api.domain.vo.UserVo;
import com.tankinfo.common.response.base.BaseApiService;
import com.tankinfo.common.response.base.BaseResponse;
import com.tankinfo.common.response.constants.ResConstants;
import com.tankinfo.receivable.api.domain.dto.ReceivableDto;
import com.tankinfo.receivable.api.domain.po.AccountPo;
import com.tankinfo.receivable.api.service.ReceivableService;
import com.tankinfo.receivable.imp.mapper.AccountMapper;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.List;


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


    @Resource
    private AccountMapper accountMapper;

    @Override
    public BaseResponse<ReceivableDto> money(String userId) {
        BaseResponse<UserDto> userResponse = authServiceFeign.userinfo();
        if (!ResConstants.HTTP_RES_CODE_200.equals(userResponse.getCode())){
            return setResultError(userResponse.getCode(), userResponse.getMsg());
        }
        Integer age = userResponse.getData().getAge();
        int money = age * 10000;
        QueryWrapper<AccountPo> queryWrapper = new QueryWrapper<>();


        List<AccountPo> accountPos = accountMapper.selectList(queryWrapper);

        ReceivableDto receivableDto = new ReceivableDto("pn", "cyw", 100000.0, 30000.0, 70000.0);
        return setResultSuccess(receivableDto);
    }

    @Override
    public BaseResponse add(String userId) {
        authServiceFeign.add(userId);
        AccountPo accountPo = new AccountPo("6704484066114142208",userId,0 ,0 ,0);
        accountMapper.updateById(accountPo);
        return setResultSuccess();
    }

//    @GlobalTransactional
    @Transactional
    @Override
    public BaseResponse update(String loginName) {
        BaseResponse temp = authServiceFeign.update(new UserVo(){{setLoginName(loginName);setPassword("000000");}});
        if(!temp.getCode().equals(ResConstants.HTTP_RES_CODE_200))
            return setResultError(temp.getMsg());
        AccountPo accountPo = new AccountPo("6704484066114142208",loginName,1.0 ,1.0 ,1.0);
        accountMapper.updateById(accountPo);
        //int a = 10/0;
        return setResultSuccess();
    }

    @Override
    public BaseResponse test(String loginName) {
        return setResultSuccess("hello world");
    }
}
