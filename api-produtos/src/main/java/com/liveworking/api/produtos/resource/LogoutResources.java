package com.liveworking.api.produtos.resource;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.liveworking.api.produtos.token.TokenUtils;

@RestController
@RequestMapping("/logout")
public class LogoutResources {

	@DeleteMapping("/expire")
	public void logout(HttpServletRequest request, HttpServletResponse response) {

		response.addCookie(TokenUtils.NewCookie("refreshToken", null, request.getContextPath(), 0));

		response.setStatus(HttpStatus.NO_CONTENT.value());

	}

}
