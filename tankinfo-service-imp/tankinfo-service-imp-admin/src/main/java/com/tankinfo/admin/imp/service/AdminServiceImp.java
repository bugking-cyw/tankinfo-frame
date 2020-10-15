package com.tankinfo.admin.imp.service;


import com.tankinfo.admin.api.domain.dto.LoginReguestDto;
import com.tankinfo.admin.api.domain.po.RolePo;
import com.tankinfo.admin.api.domain.po.UserPo;
import com.tankinfo.admin.api.service.AdminService;
import com.tankinfo.admin.imp.feign.AuthServiceFeign;
import com.tankinfo.admin.imp.manage.AdminManager;
import com.tankinfo.common.constant.AuthConstant;
import com.tankinfo.common.response.base.BaseApiService;
import com.tankinfo.common.response.base.BaseResponse;
import com.tankinfo.system.auth.UserDto;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Company: TANKINFO 坦克信息
 * @Author: Mr.cyw
 * @Machine: chenyawen
 * @Date: 2020/10/12 5:53 下午
 * @Description: Please Write notes scientifically
 */
@RestController
public class AdminServiceImp extends BaseApiService implements AdminService {

    @Resource
    private AdminManager adminManager;

    @Resource
    private AuthServiceFeign authServiceFeign;


    @Override
    public BaseResponse login(LoginReguestDto loginReguestDto) throws Exception{
        String username = loginReguestDto.getUsername();
        String password = loginReguestDto.getPassword();
        if(StringUtils.isEmpty(username)||StringUtils.isEmpty(password)){
            throw new RuntimeException("用户密码不能为空");
        }
        Map<String, String> params = new HashMap<>();
        params.put("client_id", AuthConstant.SYSTEM_CLIENT_ID);
        params.put("client_secret",AuthConstant.SYSTEM_CLIENT_SECRET);
        params.put("grant_type","password");
        params.put("username",username);
        params.put("password",password);
        BaseResponse response = authServiceFeign.token(params);
        return response;
    }

    @Override
    public UserDto loadUserByName(String userName) {
        UserPo userPo = adminManager.userPoByName(userName);
        List<RolePo> rolePos = adminManager.rolesByName(userPo);
        UserDto userDto = new UserDto();
        userDto.setId(userPo.getUserId());
        userDto.setUsername(userPo.getLoginName());
        userDto.setStatus(userPo.getIsValid()?1:0);
        userDto.setPassword(userPo.getPassword());
        userDto.setRoles(rolePos.stream().map(RolePo::getRoleCode).collect(Collectors.toList()));
        return userDto;
    }

    @Override
    public BaseResponse currentUser() {
        Map<String, Object> result = new HashMap<>();
        UserDto userDto = adminManager.userByRequest();
        List<RolePo> rolePos = adminManager.rolesByName(new UserPo() {{
            setUserId(userDto.getId());
        }});
        result.put("user", userDto);
        result.put("roles", rolePos);
        return setResultSuccess(result);
    }

    @Override
    public BaseResponse logout() {
        //BaseResponse response = authServiceFeign.removeToken();
        return setResultSuccess();
    }
}
