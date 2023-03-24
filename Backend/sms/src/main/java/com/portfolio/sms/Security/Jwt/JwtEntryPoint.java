package com.portfolio.sms.Security.Jwt;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class JwtEntryPoint implements AuthenticationEntryPoint {
    private final static Logger logger = LoggerFactory.getLogger(JwtEntryPoint.class);

    @Override
    public void commence(HttpServletRequest request
            , HttpServletResponse response, AuthenticationException authException) throws IOException {
    logger.error("fallo el metodo commence");
    response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
    }
}
