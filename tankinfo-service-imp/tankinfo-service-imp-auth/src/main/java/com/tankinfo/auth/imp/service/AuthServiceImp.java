package com.tankinfo.auth.imp.service;

import com.alibaba.fastjson.JSONObject;
import com.tankinfo.auth.api.service.AuthService;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @Company: FIT2CLOUD 飞致云
 * @Author: Mr.cyw
 * @Machine: chenyawen
 * @Date: 2020/9/4 6:06 下午
 * @Description: Please Write notes scientifically
 */
@RestController
public class AuthServiceImp implements AuthService {

    @Override
    public String userinfo() {
        HashMap<Object, Object> hashMap = new HashMap<>();
        hashMap.put("name","cyw");
        hashMap.put("age",28);
        hashMap.put("position", "coder");
        return JSONObject.toJSONString(hashMap);
    }

    @Override
    public String userInfo(String userId) {
        return null;
    }
}
