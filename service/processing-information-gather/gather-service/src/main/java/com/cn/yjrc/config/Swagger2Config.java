package com.cn.yjrc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger2API文档的配置
 */
@Configuration
// 开启swagger2
@EnableSwagger2
public class Swagger2Config {
    @Bean
    public Docket createRestApi(Environment environment){
        // 通过外部环境进行判断是否开启swagger
        Profiles of = Profiles.of("dev", "test");
        boolean flag = environment.acceptsProfiles(of);

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                // 分组用
                .groupName("王大凯")
                .enable(flag) // swagger 是否启用；
                .select()
                // RequestHandlerSelectors要扫描接口的方式
                .apis(RequestHandlerSelectors.basePackage("com.cn.yjrc"))
                // PathSelectors 过滤器
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * swagger-info 的配置信息
     * @return
     */
    private ApiInfo apiInfo() {

        Contact contact = new Contact("zjdking","http://baidu.com","718379629@qq.com");
        return new ApiInfoBuilder()
                .title("SwaggerUI-- processing-information-gather")
                .description("1.根据传入的用户证件号码，调用各人才服务业务的在办业务信息功能。\n " +
                        "（1）调用工作居住证在办业务信息功能，获取工作居住证在办业务信息。\n" +
                        "（2）调用引进人才在办业务信息功能，获取引进人才在办业务信息。\n" +
                        "（3）调用干部调京在办业务信息功能，获取干部调京在办业务信息。\n" +
                        "（4）调用。。。在办业务信息功能，获取。。。在办业务信息。")
                .contact(contact)
                .version("1.0")
                .build();
    }
}
