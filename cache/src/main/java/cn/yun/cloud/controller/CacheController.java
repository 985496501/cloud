package cn.yun.cloud.controller;

import cn.yun.cloud.common.Result;
import cn.yun.cloud.utils.RedisUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author jinyun liu
 * @date 2020/5/8
 */
@RestController
@RequestMapping("cache")
@Api(tags = "测试redis的基本操作")
public class CacheController {
    @Resource
    private RedisUtil redisUtil;

    @GetMapping("get")
    @ApiOperation("通过key获取redis的value")
    @ApiImplicitParam(name = "key", type = "string", required = true)
    public Result getValue(String key) {
        String s = redisUtil.get(key);
        return Result.ok(s);
    }


    @PostMapping("set")
    @ApiOperation("redis里set value")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "key", value = "存储的键值对的key", type = "String", required = true),
            @ApiImplicitParam(name = "value", value = "存储的键值对的value", type = "String", required = true)
    })
    public Result setValue(String key, String value) {
        redisUtil.set(key, value);
        return Result.ok();
    }

}
