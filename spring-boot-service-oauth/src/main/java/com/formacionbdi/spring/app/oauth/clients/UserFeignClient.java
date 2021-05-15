package com.formacionbdi.spring.app.oauth.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.formacionbdi.spring.app.users.commons.models.entity.User;

@FeignClient(name="user-internal-service")
public interface UserFeignClient {
	
	@GetMapping("/user/search/find-username")
	public User findByUsername(@RequestParam String username);

}
