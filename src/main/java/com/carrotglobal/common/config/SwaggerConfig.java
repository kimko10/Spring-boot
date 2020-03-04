package com.carrotglobal.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				//.apis(RequestHandlerSelectors.withClassAnnotation(RestController.class)) // RestController 어노테이션이 붙은 클래스들
				.apis(RequestHandlerSelectors.basePackage("com.carrotglobal"))
				.paths(PathSelectors.any())
				//.apis(RequestHandlerSelectors.any()) // 현재 RequestMapping으로 할당된 모든 URL 추출
				//.paths(PathSelectors.ant("/rest/**")) // 그 중 해당경로 인 URL만 필터링
				.build();
	}

}
