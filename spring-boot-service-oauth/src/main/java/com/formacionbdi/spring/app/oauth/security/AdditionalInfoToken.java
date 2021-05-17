package com.formacionbdi.spring.app.oauth.security;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import com.formacionbdi.spring.app.oauth.services.UserInfoService;
import com.formacionbdi.spring.app.users.commons.models.entity.User;

@Component
public class AdditionalInfoToken implements TokenEnhancer{
	
	private static Logger log = LoggerFactory.getLogger(AdditionalInfoToken.class);
	
	@Autowired
	UserInfoService userInfoService;

	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		User user = userInfoService.findByUsername(authentication.getName());
		log.info("enhance: " + user.getName() + " - " + user.getLastname() + " - " + user.getEmail());
		
		Map<String, Object> info = new HashMap<>();
		info.put("name", user.getName());
		info.put("lastname", user.getLastname());
		info.put("email", user.getEmail());
		
//		DefaultOAuth2AccessToken def = (DefaultOAuth2AccessToken) accessToken;
//		def.setAdditionalInformation(info);
//		log.info("additionalInfo: " + def.getAdditionalInformation().toString()); 
//		return def;
		
		((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);
		return accessToken;
	}
	
}
