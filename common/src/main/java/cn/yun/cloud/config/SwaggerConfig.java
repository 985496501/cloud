package cn.yun.cloud.config;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author: Liu Jinyun
 * @date: 2020/5/4/12:12
 */
@EnableSwagger2
@Configuration
public class SwaggerConfig {

    /**
     * select() : 选择那些路径和api会生成document
     * apis() : 对所有api进行监控
     *
     * @return
     */
    @Bean
    public Docket docket() {
        // 可以查看官方文档，这个docket还有很多功能，案卷
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .pathMapping("/")
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(Predicates.not(PathSelectors.regex("/error.*")))
                .paths(PathSelectors.regex("/.*"))
                .build();
    }

    private ApiInfo apiInfo() {
        //Contact contact = new Contact("jinyun liu", null, "985496501@qq.com");

        return new ApiInfoBuilder().title("刘津运的swagger接口文档")
                .description("第一次玩这个接口文档, 先试试.")
                .version("1.0")
                //.contact(contact)
                .build();
    }

}
