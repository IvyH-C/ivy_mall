package com.mall.ivy.core.redis;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;


@Service
public class RedisServiceImpl implements RedisService {
    @Resource
    private RedisTemplate redisTemplate;

    @Override
    public void setKey(String key, String value) {
        ValueOperations<String, String> ops = redisTemplate.opsForValue();
        // 设置15分钟的有效期
        ops.set(key, value, 15,TimeUnit.MINUTES);
    }

    public void setKey(String key, String value, Long time){
        ValueOperations<String, String> ops = redisTemplate.opsForValue();
        //可自定义有效期,以分为单位（验证码等）
        ops.set(key, value, time, TimeUnit.MINUTES);
    }



    @Override
    public String getValue(String key) {
        ValueOperations<String, String> ops = redisTemplate.opsForValue();
        return ops.get(key);
    }

    @Override
    public void delete(String key) {
        redisTemplate.delete(key);
    }
}