package com.example.redis.practice.config;

import java.lang.reflect.Method;

import org.springframework.cache.interceptor.KeyGenerator;

public class CustomKeyGenerator implements KeyGenerator {
 
    public Object generate(Object target, Method method, Object[] params) {
        Integer r = Integer.parseInt((String) params[0]);
        Integer r1 = Integer.parseInt((String) params[1]);
        return target.getClass().getSimpleName() + "_" + method.getName() + "_" + (r + r1);
    }
}