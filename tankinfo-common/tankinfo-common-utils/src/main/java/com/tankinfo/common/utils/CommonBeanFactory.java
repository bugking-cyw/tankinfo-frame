package com.tankinfo.common.utils;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @Company: TANKINFO 坦克信息
 * @Author: Mr.cyw
 * @Machine: chenyawen
 * @Date: 2020/9/14 1:30 下午
 * @Description: Please Write notes scientifically
 */
@Component
public class CommonBeanFactory implements ApplicationContextAware {
    private static ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

    /**
     * 根据名称获取Bean
     *
     * @param beanName bean名称
     * @return Bean实例
     */
    public static<T> T getBean(String beanName) {
        if (context == null || StringUtils.isBlank(beanName)) {
            return null;
        }
        return (T)context.getBean(beanName);
    }

    /**
     * 根据类型获取Bean
     *
     * @param className bean类型
     * @param <T>       bean类型
     * @return Bean实例
     */
    public static <T> T getBean(Class<T> className) {
        if (context == null || className == null) {
            return null;
        }
        return context.getBean(className);
    }
}
