package com.tankinfo.receivable.imp;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tankinfo.common.utils.SnowflakeIdUtils;
import com.tankinfo.receivable.api.domain.po.AccountPo;
import com.tankinfo.receivable.imp.mapper.AccountMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Company: TANKINFO 坦克信息
 * @Author: Mr.cyw
 * @Machine: chenyawen
 * @Date: 2020/9/8 4:01 下午
 * @Description: Please Write notes scientifically
 */


@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringTest {

    @Autowired(required = false)
    private AccountMapper accountMapper;

    @Test
    public void test(){
        QueryWrapper<AccountPo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("account_id", "6702303469455278080");
        List<AccountPo> accountPos = accountMapper.selectList(queryWrapper);
        System.out.printf(JSONObject.toJSONString(accountPos));
    }

    @Test
    public void  save(){
        AccountPo accountPo = new AccountPo();
        accountPo.setAccountId(SnowflakeIdUtils.getSnowflakeId()+"");
        accountPo.setUserId("cyw");
        accountPo.setTotal(100000.0);
        accountPo.setPaid(20000.0);
        accountPo.setDue(80000.0);
        int i = accountMapper.insert(accountPo);
        System.out.printf(i+"");
    }

}
