//package com.cts.ba2;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
//import org.springframework.stereotype.Component;
//
////
//@Component
//public class SecurityEntryPoint extends BasicAuthenticationEntryPoint {
//
//	@Override
//	public void afterPropertiesSet() {
//		// TODO Auto-generated method stub
//		setRealmName("Same -app");
//		super.afterPropertiesSet();
//	}
//
//	@Override
//	public void commence(HttpServletRequest request, HttpServletResponse response,
//			AuthenticationException authException) throws IOException {
//		
//		response.addHeader("WWW-Authenticate", "Basic realm=\"" + getRealmName());
//		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
////		response.sendError(HttpStatus.UNAUTHORIZED.value(), HttpStatus.UNAUTHORIZED.getReasonPhrase());
//			PrintWriter write=response.getWriter();
//			write.println("401- UNAUTHORIZED!!!!!!");
//		// TODO Auto-generated method stu
//	}
//	
//
//}
