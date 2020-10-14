package com.tankinfo.admin.feign;

import com.tankinfo.common.response.base.BaseResponse;
import com.tankinfo.system.auth.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Map;

/**
 * @Company: TANKINFO 坦克信息
 * @Author: Mr.cyw
 * @Machine: chenyawen
 * @Date: 2020/10/13 5:25 下午
 * @Description: Please Write notes scientifically
 */

@FeignClient("tankinfo-admin")
public interface AdminServiceFeign  {

    @PostMapping(value = "/admin/loadUserByName")
    UserDto loadUserByName(@RequestParam String userName);
}
