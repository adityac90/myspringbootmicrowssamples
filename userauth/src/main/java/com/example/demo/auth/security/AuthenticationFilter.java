package com.example.demo.auth.security;

import com.example.demo.auth.model.LoginRequestModel;
import com.example.demo.auth.services.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private UserService userService;
    private Environment environment;

    public AuthenticationFilter(UserService userService, Environment environment, AuthenticationManager authenticationManager) {
        this.userService = userService;
        this.environment = environment;
        super.setAuthenticationManager(authenticationManager);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        Authentication authenticate = null;
        try {

            //get the values from request
            final LoginRequestModel loginRequestModel = new ObjectMapper().readValue(request.getInputStream(), LoginRequestModel.class);
            authenticate = getAuthenticationManager().authenticate(new UsernamePasswordAuthenticationToken(loginRequestModel.getEmail(), loginRequestModel.getPassword(), new ArrayList<>()));


        } catch (IOException e) {
            e.printStackTrace();
        }
        return authenticate;

    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        final String email = ((User) authResult.getPrincipal()).getUsername();
        com.example.demo.auth.model.User user = userService.finduUserByEmail(email);
        String token = Jwts.builder().setSubject(user.getUser_name()).setExpiration(new Date(System.currentTimeMillis() + environment.getProperty("token.expiration.time", Long.class)))
                .signWith(SignatureAlgorithm.HS512, environment.getProperty("token.secret")).compact();
        response.addHeader("token", token);
    }


}
