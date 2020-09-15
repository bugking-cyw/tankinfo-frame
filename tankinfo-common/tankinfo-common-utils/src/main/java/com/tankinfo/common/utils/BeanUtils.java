package com.tankinfo.common.utils;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @Company: TANKINFO 坦克信息
 * @Author: Mr.cyw
 * @Machine: chenyawen
 * @Date: 2020/9/14 3:18 下午
 * @Description: Please Write notes scientifically
 */
public class BeanUtils {

    public static <T> T copyBean(T target, Object source) {
        try {
            org.springframework.beans.BeanUtils.copyProperties(source, target);
            return target;
        } catch (Exception e) {
            throw new RuntimeException("Failed to copy object: ", e);
        }
    }

    public static <T> T copyBean(T target, Object source, String... ignoreProperties) {
        try {
            org.springframework.beans.BeanUtils.copyProperties(source, target, ignoreProperties);
            return target;
        } catch (Exception e) {
            throw new RuntimeException("Failed to copy object: ", e);
        }
    }

    public static Object getFieldValueByName(String fieldName, Object bean) {
        try {
            if (StringUtils.isBlank(fieldName)) {
                return null;
            }
            String firstLetter = fieldName.substring(0, 1).toUpperCase();
            String getter = "get" + firstLetter + fieldName.substring(1);
            Method method = bean.getClass().getMethod(getter);
            return method.invoke(bean);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void setFieldValueByName(Object bean, String fieldName, Object value, Class<?> type) {
        try {
            if (StringUtils.isBlank(fieldName)) {
                return;
            }
            String firstLetter = fieldName.substring(0, 1).toUpperCase();
            String setter = "set" + firstLetter + fieldName.substring(1);
            Method method = bean.getClass().getMethod(setter, type);
            method.invoke(bean, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Method getMethod(Object bean, String fieldName, Class<?> type) {
        try {
            if (StringUtils.isBlank(fieldName)) {
                return null;
            }
            String firstLetter = fieldName.substring(0, 1).toUpperCase();
            String setter = "set" + firstLetter + fieldName.substring(1);
            return bean.getClass().getMethod(setter, type);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * @param obj
     * @return
     */
    public static Map<String, Object> objectToMap(Object obj) {

        HashMap<String, Object> map = new HashMap<>();
        if (obj != null) {
            ReflectionUtils.doWithFields(obj.getClass(), field -> {
                boolean accessFlag = field.isAccessible();
                try {
                    String varName = field.getName();
                    field.setAccessible(true);
                    Object o = field.get(obj);
                    if (o != null) {
                        map.put(varName, field.get(obj));
                    }
                    field.setAccessible(accessFlag);
                } catch (Exception e) {

                } finally {
                    field.setAccessible(accessFlag);
                }
            });
        }
        return map;
    }
}
