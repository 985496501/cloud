import cn.yun.cloud.CacheApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author jinyun liu
 * @date 2020/5/6
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = CacheApplication.class)
public class CacheTest {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void test() {
        stringRedisTemplate.opsForValue().append("name", "architect");
        String name = stringRedisTemplate.opsForValue().get("name");
        System.out.println(name);
    }

}
