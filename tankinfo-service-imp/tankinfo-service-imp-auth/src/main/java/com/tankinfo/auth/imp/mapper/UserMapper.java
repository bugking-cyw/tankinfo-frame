package com.tankinfo.auth.imp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tankinfo.auth.api.domain.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Company: TANKINFO 坦克信息
 * @Author: Mr.cyw
 * @Machine: chenyawen
 * @Date: 2020/9/14 5:02 下午
 * @Description: Please Write notes scientifically
 */
@Mapper
public interface UserMapper extends BaseMapper<UserDto> {
}
