package com.tankinfo.basic.auth.init;

import com.tankinfo.common.constant.RedisConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @Company: TANKINFO 坦克信息
 * @Author: Mr.cyw
 * @Machine: chenyawen
 * @Date: 2020/9/23 8:51 下午
 * @Description: Please Write notes scientifically
 */
@Component
public class PermissionSetInit implements ApplicationRunner {

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Map<String, List<String>> resourceRolesMap = new TreeMap<>();

        resourceRolesMap.put("/api/hello", CollectionUtils.arrayToList(new String[]{"ADMIN"}));
        resourceRolesMap.put("/api/user/currentUser", CollectionUtils.arrayToList(new String[]{"ADMIN","TEST"}));
        redisTemplate.opsForHash().putAll(RedisConstant.RESOURCE_ROLES_MAP, resourceRolesMap);

    }
}
