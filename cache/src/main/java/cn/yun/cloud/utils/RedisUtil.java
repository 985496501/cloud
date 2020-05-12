package cn.yun.cloud.utils;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author jinyun liu
 * @date 2020/5/8
 */
@Service
public class RedisUtil {
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    public void set(String key, String value) {
        stringRedisTemplate.opsForValue().set(key, value);
    }

    public String get(String key) {
        return stringRedisTemplate.opsForValue().get(key);
    }
}
