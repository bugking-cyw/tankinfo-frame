package com.tankinfo.admin.imp.manage;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tankinfo.admin.api.domain.po.RolePo;
import com.tankinfo.admin.api.domain.po.UserPo;
import com.tankinfo.admin.imp.mapper.RoleMapper;
import com.tankinfo.admin.imp.mapper.UserMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Company: TANKINFO 坦克信息
 * @Author: Mr.cyw
 * @Machine: chenyawen
 * @Date: 2020/10/14 9:59 上午
 * @Description: Please Write notes scientifically
 */
@Component
public class AdminManager {

    @Resource
    private UserMapper userMapper;

    @Resource
    private RoleMapper roleMapper;

    public UserPo userPoByName(String loginName){
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("login_name", loginName);
        return userMapper.selectOne(queryWrapper);
    }

    public List<RolePo> rolesByName(UserPo userPo){
        return roleMapper.rolesByUserId(userPo.getUserId());
    }
}
