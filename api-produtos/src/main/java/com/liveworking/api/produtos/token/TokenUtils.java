package com.liveworking.api.produtos.token;

import javax.servlet.http.Cookie;

import org.springframework.beans.factory.annotation.Autowired;

import com.liveworking.api.produtos.config.property.ApiProperty;

public final class TokenUtils {
	
	
	 
	
	public static Cookie NewCookie(String name, String value, String Path, int maxAge) {
	
		ApiProperty apiProperty = new ApiProperty();
		
		Cookie cookie = new Cookie(name, value);

		cookie.setHttpOnly(true);
		cookie.setSecure(apiProperty.getSecurity().isEnableHttps());
		cookie.setPath(Path + "/oauth/token");
		cookie.setMaxAge(maxAge);
		
		return cookie; 
		
	}

}
