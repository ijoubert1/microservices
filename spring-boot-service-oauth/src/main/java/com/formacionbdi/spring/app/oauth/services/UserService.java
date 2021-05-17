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

@Service
public class UserService implements UserDetailsService {

	private static Logger log = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserFeignClient userClient;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userClient.findByUsername(username);
		
		if (user == null) {
			log.error("User not found " + username);
			throw new UsernameNotFoundException("User not found");
		}
		
		List<GrantedAuthority> authorities = user.getRoles().stream().map(r -> new SimpleGrantedAuthority(r.getName()))
				.peek(authority -> log.info("Authority: " + authority.getAuthority()))
				.collect(Collectors.toList());
		log.info("User authenticated: " + username);
		
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				user.getEnabled(), true, true, true, authorities);
	}
}
