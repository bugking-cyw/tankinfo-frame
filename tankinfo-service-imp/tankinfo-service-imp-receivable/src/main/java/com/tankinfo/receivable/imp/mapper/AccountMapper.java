package com.tankinfo.receivable.imp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tankinfo.receivable.api.domain.po.AccountPo;
import org.apache.ibatis.annotations.Mapper;


/**
 * @Company: TANKINFO 坦克信息
 * @Author: Mr.cyw
 * @Machine: chenyawen
 * @Date: 2020/9/8 3:58 下午
 * @Description: Please Write notes scientifically
 */
@Mapper
public interface AccountMapper extends BaseMapper<AccountPo> {
}
