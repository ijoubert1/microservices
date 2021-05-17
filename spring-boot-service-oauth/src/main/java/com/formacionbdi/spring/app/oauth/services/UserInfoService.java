package com.formacionbdi.spring.app.oauth.services;

import com.formacionbdi.spring.app.users.commons.models.entity.User;

public interface UserInfoService {

	public User findByUsername(String username);
}
