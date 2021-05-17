package com.formacionbdi.spring.app.oauth.services;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.formacionbdi.spring.app.oauth.clients.UserFeignClient;
import com.formacionbdi.spring.app.users.commons.models.entity.User;

import feign.FeignException;

@Service
public class UserService implements UserDetailsService, UserInfoService {

	private static Logger log = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserFeignClient userClient;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		try {
			User user = userClient.findByUsername(username);

			List<GrantedAuthority> authorities = user.getRoles().stream()
					.map(r -> new SimpleGrantedAuthority(r.getName()))
					.peek(authority -> log.info("Authority: " + authority.getAuthority())).collect(Collectors.toList());
			log.info("User authenticated: " + username);

			return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
					user.getEnabled(), true, true, true, authorities);
		} catch (FeignException e) {
			log.error("User not found " + username);
			throw new UsernameNotFoundException("User not found");
		}
	}

	@Override
	public User findByUsername(String username) {
		return userClient.findByUsername(username);
	}

	@Override
	public User updateUser(User user, Long id) {
		return userClient.updateUser(user, id);
	}
}
