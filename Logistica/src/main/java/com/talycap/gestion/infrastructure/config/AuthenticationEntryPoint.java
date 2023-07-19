package com.talycap.gestion.infrastructure.config;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationEntryPoint extends BasicAuthenticationEntryPoint {

	@Override 
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authEx)
      throws IOException{
        response.addHeader("WWW-Authenticate", "Basic realm=" +getRealmName());
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        System.out.print("getRealmName: "+getRealmName());
        System.out.println("response.getWriter(): "+response.getWriter());
        System.out.print("authEx.getCause(): "+authEx.getCause());
        System.out.println("AUTHENTICATION ERROR: "+authEx.getMessage());
        PrintWriter writer = response.getWriter();
        writer.println("HTTP Status 401 - " + authEx.getCause());
    }

	@Override
    public void afterPropertiesSet() {
        setRealmName("DeveloperStack");
        super.afterPropertiesSet();
    }

}
