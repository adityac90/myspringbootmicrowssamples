package com.example.spring.microws.zuul.security;

import io.jsonwebtoken.Jwts;
import org.apache.commons.lang.StringUtils;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class AuthenticationFilter extends BasicAuthenticationFilter {
    private Environment environment;

    public AuthenticationFilter(AuthenticationManager authenticationManager, Environment environment) {
        super(authenticationManager);
        this.environment = environment;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        //First read the Authorization header from the request
        String authorizationHeader = request.getHeader(environment.getProperty("jwt.authorization.token.header.name"));
        if (StringUtils.isBlank(authorizationHeader) || !authorizationHeader.startsWith(environment.getProperty("jwt.authorization.token.header.prefix"))) {
            chain.doFilter(request, response);
            return;
        }

        UsernamePasswordAuthenticationToken authenticationToken = getAuthenticationToken(request, authorizationHeader);
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        chain.doFilter(request, response);
    }

    private UsernamePasswordAuthenticationToken getAuthenticationToken(HttpServletRequest request, String authorizationHeader) {
        String token = authorizationHeader.replace(environment.getProperty("jwt.authorization.token.header.prefix"), "");
        String parsedUserId = Jwts.parser().
                setSigningKey(environment.getProperty("jwt.token.secret"))
                .parseClaimsJws(token).getBody()
                .getSubject();
        if (StringUtils.isBlank(parsedUserId)) {
            return null;
        }
        return new UsernamePasswordAuthenticationToken(parsedUserId, null, new ArrayList<>());

    }


}
