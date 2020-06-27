package com.mall.ivy.core.redis;

public interface RedisService {
    /**
     * 设置key-value
     * @param key
     * @param value
     */
    void setKey(String key, String value);

    /**
     * 获取key
     * @param key
     * @return
     */
    String getValue(String key);

    /**
     * 删除key
     * @param key
     */
    void delete(String key);

    /**
     * 自定义过期时间
     * @param key
     * @param value
     * @param time
     */
    void setKey(String key, String value, Long time);
}
