package com.test.config;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	// "/swagger-ui.html"

	private ApiInfo swaggerInfo() {
		return new ApiInfoBuilder().title("Uptempo Auto AppTest Server").description("Uptempo Auto AppTest Server Docs")
				.build();
	}

	@Bean
	public Docket swaggerApi() {
		return new Docket(DocumentationType.SWAGGER_2).consumes(this.getConsumeContentTypes())
				.produces(this.getProduceContentTypes()).apiInfo(this.swaggerInfo()).select()
				.apis(RequestHandlerSelectors.any()).paths(PathSelectors.any()).build()
				.useDefaultResponseMessages(false);
	}

	private Set<String> getConsumeContentTypes() {
		Set<String> consumes = new HashSet<>();
		consumes.add("application/json;charset=UTF-8");
		consumes.add("application/x-www-form-urlencoded");
		return consumes;
	}

	private Set<String> getProduceContentTypes() {
		Set<String> produces = new HashSet<>();
		produces.add("application/json;charset=UTF-8");
		return produces;
	}
}
