package com.cts.ba2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;

import com.netflix.eureka.registry.rule.AlwaysMatchInstanceStatusRule;

import brave.sampler.Sampler;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableEurekaClient
@EnableSwagger2
@EnableHystrix
public class EmployeeApplication {
	public static final Contact DEFAULT_CONTACT = new Contact("Divirt ", "Divrit97@gmail.com", "8222055777");
	  public static final ApiInfo DEFAULT_Api = new ApiInfo("Employee Service", "Api Documentation", "1.0", "urn:tos",
	          DEFAULT_CONTACT, "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0");
	  
	public static void main(String[] args) {
		SpringApplication.run(EmployeeApplication.class, args);
	}
	
	@Bean
	public Docket api() {
	
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(DEFAULT_Api);
	}
	
	
	@Bean
	public Sampler defaultsampler() {
		return Sampler.ALWAYS_SAMPLE;
			
	}
}

