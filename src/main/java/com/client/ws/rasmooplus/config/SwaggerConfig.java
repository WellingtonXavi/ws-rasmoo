package com.client.ws.rasmooplus.config;

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
	
	  
	
	  @Bean public Docket api() { return new
	  Docket(DocumentationType.SWAGGER_2).useDefaultResponseMessages(false).
	  groupName("v0").select() .apis(RequestHandlerSelectors.basePackage(
	  "com.client.ws.rasmooplus.api.controller"))
	  .paths(PathSelectors.any()).build().apiInfo(this.apiInfo()); }
	  
	  private ApiInfo apiInfo() { ApiInfoBuilder apiInfoBuilder = new
	  ApiInfoBuilder();
	  
	  return apiInfoBuilder .title("Rasmoo Plus")
	  .description("Api para anteder o client o Rasmoo Plus") .version("0.0.1")
	  .license("Rasmoo Curso de Tecnologia") .build(); }
	 
	 }
