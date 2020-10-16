package com.tankinfo.auth.service;

import com.tankinfo.auth.domain.ResourceEntity;
import com.tankinfo.auth.mapper.ResourceEntityMapper;
import com.tankinfo.common.constant.RedisConstant;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

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

    @Resource
    private ResourceEntityMapper resourceEntityMapper;

    public void loadResource(){

        Map<String, List<String>> resourceRolesMap = new TreeMap<>();
        List<ResourceEntity> resourceEntities = resourceEntityMapper.resourceEnties();
        resourceRolesMap = resourceEntities.stream().collect(Collectors.toMap(ResourceEntity::getUrl,entity -> {
            String role_codes = entity.getRoleCodes();
            return CollectionUtils.arrayToList(role_codes.split(","));
        }));
        redisTemplate.opsForHash().putAll(RedisConstant.RESOURCE_ROLES_MAP, resourceRolesMap);
    }


}
