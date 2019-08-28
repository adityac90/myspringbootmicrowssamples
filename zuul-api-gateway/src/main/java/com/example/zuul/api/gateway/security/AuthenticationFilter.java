package com.example.zuul.api.gateway.security;

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
        String jwTTokenFromReq = request.getHeader("Authorization");
        if (StringUtils.isBlank(jwTTokenFromReq) || !StringUtils.startsWith(jwTTokenFromReq, "Bearer")) {
            chain.doFilter(request, response);
            return;
        }
        UsernamePasswordAuthenticationToken authenticationToken = getAuthenticationToken(request, jwTTokenFromReq);
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        chain.doFilter(request,response);
    }

    private UsernamePasswordAuthenticationToken getAuthenticationToken(HttpServletRequest request, String token) {
        String rawToken = token.replace("Bearer", "");
        String userName = Jwts.parser().setSigningKey(environment.getProperty("token.secret")).parseClaimsJws(rawToken)
                .getBody().getSubject();

        if (userName == null) {
            return null;
        }
        return new UsernamePasswordAuthenticationToken(userName, null, new ArrayList<>());
    }
}
