package com.tankinfo.admin.imp.manage;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tankinfo.admin.api.domain.po.RolePo;
import com.tankinfo.admin.api.domain.po.UserPo;
import com.tankinfo.admin.imp.mapper.RoleMapper;
import com.tankinfo.admin.imp.mapper.UserMapper;
import com.tankinfo.common.constant.AuthConstant;
import com.tankinfo.system.auth.UserDto;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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

    @Resource
    private HttpServletRequest request;

    public UserPo userPoByName(String loginName){
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("login_name", loginName);
        return userMapper.selectOne(queryWrapper);
    }

    public List<RolePo> rolesByName(UserPo userPo){
        return roleMapper.rolesByUserId(userPo.getUserId());
    }

    public UserDto userByRequest(){
        String userStr = request.getHeader(AuthConstant.USER_TOKEN_HEADER);
        if (StringUtils.isEmpty(userStr)){
            throw new RuntimeException("当前登录用户信息为空");
        }
        UserDto userDto = JSONObject.parseObject(userStr, UserDto.class);
        return userDto;
    }
}
