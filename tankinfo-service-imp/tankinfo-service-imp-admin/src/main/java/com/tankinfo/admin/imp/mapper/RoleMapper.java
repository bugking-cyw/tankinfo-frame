package com.tankinfo.admin.imp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tankinfo.admin.api.domain.po.RolePo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Company: TANKINFO 坦克信息
 * @Author: Mr.cyw
 * @Machine: chenyawen
 * @Date: 2020/10/14 10:05 上午
 * @Description: Please Write notes scientifically
 */
@Mapper
public interface RoleMapper extends BaseMapper<RolePo> {

    @Select("select r.* from role r left join role_user ru on r.role_id = ru.role_id where ru.user_id = #{userId}")
    public List<RolePo> rolesByUserId(@Param("userId") Long userId);
}
