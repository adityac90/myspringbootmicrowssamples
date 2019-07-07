package com.example.spring.microws.zuul.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {

    private Environment environment;

    @Autowired
    public WebSecurity(Environment environment) {
        this.environment = environment;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().headers().frameOptions().disable();
        //Allow User Registration, User Login and H2 console access without a web token
        //For any other request authenticate whether it has a valid web token or not
        http.authorizeRequests().antMatchers(HttpMethod.POST, environment.getProperty("api.login.url.path")).permitAll()
                .antMatchers(HttpMethod.POST, environment.getProperty("api.registration.url.path")).permitAll()
                .antMatchers(environment.getProperty("api.h2.console.url.path")).permitAll()
                .anyRequest().authenticated()
                .and()
                .addFilter(authenticationFilter());
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

    }

    @Bean
    public AuthenticationFilter authenticationFilter() {
        AuthenticationFilter authenticationFilter = null;
        try {
            authenticationFilter = new AuthenticationFilter(authenticationManager(), environment);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return authenticationFilter;
    }
}
