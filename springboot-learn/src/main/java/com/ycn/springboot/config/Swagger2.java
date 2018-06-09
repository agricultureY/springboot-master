package com.ycn.springboot.config;

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
 * Swagger2配置
 * 		http://ip:port/swagger-ui.html
 * @Package: com.ycn.springboot.config
 * @author: ycn
 * @date: 2018年5月17日 下午3:43:42
 */
@Configuration
@EnableSwagger2
public class Swagger2 {

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("Spring Boot中使用Swagger2构建RESTful APIs")
				.description("spring boot整合Swagger2案例")
				.termsOfServiceUrl("www.baidu.com")
				.version("V1.0.0")
				.build();
	}

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.ycn.springboot.web"))
                .paths(PathSelectors.any())
                .build();
    }
}
