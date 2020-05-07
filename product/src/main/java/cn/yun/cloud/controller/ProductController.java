package cn.yun.cloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author: Liu Jinyun
 * @date: 2020/5/4/12:54
 */
@Slf4j
@RestController
@RequestMapping("product")
public class ProductController {

    @GetMapping("query")
    public String noneProductCurrently() {
        // simulate net block.
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "none product currently";
    }

}
