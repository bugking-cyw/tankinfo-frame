package com.tankinfo.auth.service;

import com.tankinfo.common.constant.RedisConstant;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @Company: TANKINFO 坦克信息
 * @Author: Mr.cyw
 * @Machine: chenyawen
 * @Date: 2020/9/28 11:46 上午
 * @Description: Please Write notes scientifically
 */
@Component
public class ResourceService {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    public void loadResource(){
        Map<String, List<String>> resourceRolesMap = new TreeMap<>();
        resourceRolesMap.put("/tankinfo-receivable/test", new ArrayList<String>(){{add("ADMIN");}});

        resourceRolesMap.put("/tankinfo-admin/admin/currentUser", new ArrayList<String>(){{add("ADMIN");add("role_test");}});
        resourceRolesMap.put("/tankinfo-admin/admin/logout", new ArrayList<String>(){{add("ADMIN");add("role_test");}});
        //resourceRolesMap.put("/tankinfo-basic-auth/removeToken", new ArrayList<String>(){{add("ADMIN");add("role_test");}});
        redisTemplate.opsForHash().putAll(RedisConstant.RESOURCE_ROLES_MAP, resourceRolesMap);
    }
}
