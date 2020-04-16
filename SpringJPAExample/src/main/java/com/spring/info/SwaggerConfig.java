package com.spring.info;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    
	/*
	 * public static final Contact DEFAULT_CONTACT = new Contact("RamaiahPillala",
	 * "http://ramaiapillala.com","ramaiahpillala@gmail.com");
	 * 
	 * public static final ApiInfo DEFAULT_API_INFO = null;
	 */
	

	/*
	 * @Bean public Docket api() { return new Docket(DocumentationType.SWAGGER_2);
	 *  
	 * }
	 */
	
	// Same above functionality i am extending 
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2);
		}
	

}
