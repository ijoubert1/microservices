package com.formacionbdi.spring.app.oauth.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.formacionbdi.spring.app.users.commons.models.entity.User;

@FeignClient(name="user-service")
public interface UserFeignClient {
	
	@GetMapping("/users/search/find-username")
	public User findByUsername(@RequestParam String username);
	
	@PutMapping("/users/{id}")
	public User updateUser(@RequestBody User user, @PathVariable Long id);

}
