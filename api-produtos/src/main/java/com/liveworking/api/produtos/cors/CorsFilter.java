package com.liveworking.api.produtos.cors;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.PortableServer.REQUEST_PROCESSING_POLICY_ID;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.liveworking.api.produtos.config.property.ApiProperty;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CorsFilter implements Filter {

	ApiProperty apiProperty = new ApiProperty();
	
	private String originPermitida = apiProperty.getOriginPermitida() ;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;

		resp.setHeader("Acess-Control-Allow-Origin", originPermitida);
		resp.setHeader("Acess-Control-Allow-Credencials", "true");
		
		if ("OPTIONS".equals(req.getMethod()) && originPermitida.equals(req.getHeader("Origin"))) {

			resp.setHeader("Acess-Control-Allow-Methods", "POST, GET, DELETE, PUT, OPTIONS");
			resp.setHeader("Acess-Control-Allow-Headers", "Authorization, content-type, Aceept ");
			resp.setHeader("Acess-Control-Max-Age", "3600");
			resp.setStatus(HttpServletResponse.SC_OK);
			
		} else {
			chain.doFilter(req, resp);
		}

	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
