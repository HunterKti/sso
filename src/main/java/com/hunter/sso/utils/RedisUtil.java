package com.hunter.sso.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * 通用的redis工具类
 *
 * @author Hunter
 * @date 2020/4/20
 */
@Component
@SuppressWarnings("unchecked")
public class RedisUtil {

    RedisTemplate redisTemplate;

    @Autowired
    public void setRedisTemplate(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void put(String key, Object value, long seconds) {
        redisTemplate.opsForValue().set(key, value, seconds, TimeUnit.SECONDS);
    }

    public String get(String key) {
        Object json = redisTemplate.opsForValue().get(key);
        if (null != json) {
            return json.toString();
        }
        return null;
    }
}
