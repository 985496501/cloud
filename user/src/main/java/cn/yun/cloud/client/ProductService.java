package cn.yun.cloud.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author: Liu Jinyun
 * @date: 2020/5/4/23:50
 */
@FeignClient("product-service")
public interface ProductService {

    /**
     * 调用商品服务查询接口
     *
     * @return 商品服务信息
     */
    @GetMapping("product/query")
    String noneProductCurrently();
}
