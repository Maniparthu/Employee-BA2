package com.cts.ba2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import brave.sampler.Sampler;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableFeignClients
@SpringBootApplication
@EnableSwagger2
public class EmployeeProjectCompositeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeProjectCompositeServiceApplication.class, args);
	}
@Bean 
public Sampler api() {
	return Sampler.ALWAYS_SAMPLE;
}

}
