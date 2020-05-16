package com.cts.ba2.feign.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cts.ba2.model.Project;
//url="localhost:8099", 
@FeignClient(name="Project-Service")
public interface ProjectClient {

	@GetMapping("/project/{id}")
	public Project getProjectById(@PathVariable("id") Long id);
}


