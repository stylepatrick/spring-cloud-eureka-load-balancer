package com.example.server.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class HttpSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http)
            throws Exception {
        http
                .cors()
                .and()
                .httpBasic()
                .and()
                .csrf().disable()
                .headers()
                .frameOptions().disable()
                .cacheControl().disable()
                .and()
                .antMatcher("/**")
                .authorizeRequests()
                .antMatchers("/api/**")
                .authenticated()
                .antMatchers("/actuator/health")
                .permitAll()
                .antMatchers("/actuator/info")
                .permitAll()
                .antMatchers("/actuator/**")
                .authenticated()
                .and()
                .formLogin();
    }
}
