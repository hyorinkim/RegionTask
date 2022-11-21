package com.region.task.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration extends WebMvcConfigurationSupport {
    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.region.task"))//RequestController를 다 스캔할 건데 어디를 범위로 스캔을 할 것인지 정하는 것
                .paths(PathSelectors.any())//any는 뭘까? documentation 스펙을 보자 https로 바뀌게 되면 update될 예정이다.
                .build();
    }
    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("API Swagger 작성법 트레이닝")
                .description("설명 부분")
                .version("1.0.0")
                .build();
    }

    @Override//swagger-ui.html 접속했을때 화면 제대로 구성안되는거 해결하는 코드
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler("/swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
        super.addResourceHandlers(registry);
    }
}

