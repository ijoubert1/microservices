package com.formacionbdi.spring.app.oauth.services;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.formacionbdi.spring.app.users.commons.models.entity.User;

public interface UserInfoService {

	public User findByUsername(String username);
	public User updateUser(@RequestBody User user, @PathVariable Long id);
}
