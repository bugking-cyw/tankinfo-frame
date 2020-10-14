package com.tankinfo.admin.init;

import com.tankinfo.admin.service.ResourceService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Company: TANKINFO 坦克信息
 * @Author: Mr.cyw
 * @Machine: chenyawen
 * @Date: 2020/9/28 11:45 上午
 * @Description: Please Write notes scientifically
 */

@Component
public class ResourceLoader implements ApplicationRunner {

    @Resource
    private ResourceService resourceService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        resourceService.loadResource();
    }
}
