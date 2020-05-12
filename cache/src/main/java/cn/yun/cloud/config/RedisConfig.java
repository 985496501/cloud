package cn.yun.cloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * @author jinyun liu
 * @date 2020/5/8
 */
@Configuration
public class RedisConfig {
    /**
     * 把redis-template加入spring IOC中
     * auto-config
     *
     * @see org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration
     * @return stringRedisTemplate
     */
//    @Bean("redisTemplate")
//    public StringRedisTemplate redisTemplate() {
//        StringRedisTemplate redisTemplate = new StringRedisTemplate();
//        redisTemplate.setConnectionFactory(new LettuceConnectionFactory());
//        return redisTemplate;
//    }

    /**
     * 我们经常使用 字符串 key-value 的简单常用操作，拿到了ops 放入IOC中
     *
     * @param redisTemplate 从Spring IOC中拿到的 redisTemplate
     * @see cn.yun.cloud.config.RedisConfig 中 {@link this.redisTemplate()}
     * @return opsForValue
     */
//    @Bean("ops")
//    public ValueOperations<String, String> valueOperations(StringRedisTemplate redisTemplate) {
//        return new StringRedisTemplate().opsForValue();
//    }
}
