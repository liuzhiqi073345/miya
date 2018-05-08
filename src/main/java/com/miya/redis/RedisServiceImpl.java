package com.miya.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;


@Service
public class RedisServiceImpl  implements RedisService {


    @Autowired
    protected RedisTemplate<String, Object> redisTemplate;

    @Resource
    protected ValueOperations<String, String> valueOperations;


    /**
     * 添加
     */
    public void set(String key, String value, long expire) {
        valueOperations.set(key, value, expire,TimeUnit.SECONDS);
    }

    /**
     * 设置过期时间
     */
    public void expire(String key,  long expire) {
        redisTemplate.expire(key, expire, TimeUnit.SECONDS);
    }

    /**
     * 查询
     */
    public String get(String key) {
        return valueOperations.get(key);
    }

     /**
     *  删除
     */
    public void delete(String key) {
        redisTemplate.delete(key);
    }



}