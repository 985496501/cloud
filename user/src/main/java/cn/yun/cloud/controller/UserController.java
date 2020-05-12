package cn.yun.cloud.controller;
import	java.util.Random;

import cn.yun.cloud.client.ProductService;
import cn.yun.cloud.entity.UserDO;
import cn.yun.cloud.http.HttpResult;
import cn.yun.cloud.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: Liu Jinyun
 * @date: 2020/5/4/11:51
 */
@Slf4j
@RestController
@RequestMapping("user")
@Api(tags = "用户管理")
public class UserController {
    @Resource
    private UserService userService;
    @Resource
    private RestTemplate restTemplate;
    @Resource
    private DiscoveryClient discoveryClient;
    @Resource
    private ProductService productService;

    @GetMapping("/{id}")
    @ApiOperation("根据id查询用户信息")
    public HttpResult<UserDO> getUserById(@PathVariable Long id) {
        UserDO userDO = userService.getById(id);
        String str = productService.noneProductCurrently();;
        try {
            // 服务之间的调用，spring提供封装了 restTemplate
            // 但是会出现什么问题呢？这样
            // 如果另一个服务的路径变化了，必须要修改代码
            // 如果另一个服务是多实例的，这个只能访问一个实例，不能路由
            // 这样代码多了之后，很难维护，看着就头疼，我写第三方接口调用和回调的时候就编码进去
            // 烦死我了，一度不想再碰那些代码
            // 所以，需要一个注册中心，做服务治理，  前提是需要服务发现和注册，然后再治理，Nacos就来了。
            // nacos == config + eureka
            // str = restTemplate.getForObject("http://localhost:8002/product/query", String.class);

            //String str2 = discoveryClientForRequest();

            // str = discoveryClientForRequest2();
        } catch (Exception e) {
            log.error("cannot connect the product-server... : {}", e.getMessage());
        }

        return new HttpResult<>(200, str, userDO);
    }

    public String discoveryClientForRequest() {
        // getInstances(多实例部署), 单实例
//        ServiceInstance serviceInstance = discoveryClient.getInstances("product-service").get(0);
        List<ServiceInstance> serviceInstances = discoveryClient.getInstances("product-service");

        // 多实例，手写一个负载均衡算法，其实就是让他随意想请求哪个请求哪个，实际是要经过一系列算法才推举出一个。0-size随机调
        // 0： inclusive  1: exclusive
        int i = new Random().nextInt(serviceInstances.size());
        ServiceInstance serviceInstance = serviceInstances.get(i);
        String url = serviceInstance.getHost() + ":" + serviceInstance.getPort();
        log.warn("获取请求商品实例的url: {}", url);
        return restTemplate.getForObject("http://" + url + "/product/query", String.class);
    }

    public String discoveryClientForRequest2() {
        String url = "product-service";
        log.warn("获取请求商品实例的url: {}", url);
        return restTemplate.getForObject("http://" + url + "/product/query", String.class);
    }
}
