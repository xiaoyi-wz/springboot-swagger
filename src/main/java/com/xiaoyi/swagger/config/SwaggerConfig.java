package com.xiaoyi.swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableOpenApi
public class SwaggerConfig {
//配置swagger的Docket 的 bean 实例 可配置多个分组 协同开发
    @Bean
    public  Docket docket1(){
        return new Docket(DocumentationType.OAS_30).groupName("A");
    }
    @Bean
    public Docket docket(Environment environment){
        //获取项目的环境：
        Profiles profiles = Profiles.of("dev", "test");
        boolean flag = environment.acceptsProfiles(profiles);
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                .groupName("萧亦")
               .enable(flag)    //enable 是否情动swagger 如果为false 则Swagger不能在浏览器中 默认true
                .select()
                //RequestHandlerSelectors 配置扫描接口的方式 basePackage 指定包  any : 扫描全部
                // none:不扫描
                // withClassAnnotation:扫描类上的注解    RestController.class
                //withMethodAnnotation:扫描方法上的注解  RequestMapping.class
                .apis(RequestHandlerSelectors.basePackage("com.xiaoyi.swagger.controller"))
                .build();
    }
    //配置swagger 信息 apiInfo
    private ApiInfo apiInfo(){
        Contact co = new Contact("萧亦", "http://www.solitude.icu", "1312448321@qq.com");
        return new ApiInfo("萧亦的SwaggerApI文档",
                "一往无前",
                "v2.0",
                "http://www.solitude.icu",
                co,
                "Apache 2.0",
                "http:www.apache.org/licenses/LICENSE-2.O",
                new ArrayList<>()
        );
    }
}
