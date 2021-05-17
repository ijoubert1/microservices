package com.formacionbdi.spring.app.oauth.security.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationEventPublisher;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.formacionbdi.spring.app.oauth.services.UserService;
import com.formacionbdi.spring.app.users.commons.models.entity.User;

import feign.FeignException;

@Component
public class AuthenticationSuccessErrorHandler implements AuthenticationEventPublisher{

	private static Logger log = LoggerFactory.getLogger(AuthenticationSuccessErrorHandler.class);
	
	@Autowired
	private UserService userService;
	
	@Override
	public void publishAuthenticationSuccess(Authentication authentication) {
		UserDetails userDetail = (UserDetails) authentication.getPrincipal();
		String username = userDetail.getUsername();
		log.info("Success login - username: " + username);
		
		try {
			User user = userService.findByUsername(username);
			if(user.getLoginAttempts() != null && user.getLoginAttempts() > 0) {
				user.setLoginAttempts(0);
				userService.updateUser(user, user.getId());
				log.info("Attempts restarted for username: " + username);
			}
		} catch (FeignException e) {
			log.error("User not found in system (success): " + username);
		}
	}

	@Override
	public void publishAuthenticationFailure(AuthenticationException exception, Authentication authentication) {
		log.error("Failed login: " + exception.getMessage());
		String username = authentication.getName();
		log.info("Failed login - username: " + username);
		
		try {
			User user = userService.findByUsername(username);
			log.info("User found: " + user.toString());
			
			int currentAttempts = user.getLoginAttempts() == null ? 0 : user.getLoginAttempts();
			log.info("currentAttempts: " + currentAttempts);
			
			user.setLoginAttempts(++currentAttempts);
			log.info("updatedAttempts: " + user.getLoginAttempts());
			
			if(user.getLoginAttempts() >= 3) {
				user.setEnabled(false);
			}
			log.info("Enabled: " + user.getEnabled());
			
			userService.updateUser(user, user.getId());			
		} catch (FeignException e) {
			log.error("User not found in system (failure): " + username);
		}
	}

}
