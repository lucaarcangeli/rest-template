package com.example.rest.config;

import com.example.rest.security.JwtConfigurer;
import com.example.rest.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;


/**
 * @author OITECH develop team - 24/01/2019
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private JwtTokenProvider jwtTokenProvider;


    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .httpBasic().disable()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers("/auth/signin").permitAll()
                .antMatchers(HttpMethod.GET, "/vehicles/**", "/v1/vehicles/**").permitAll()
                .antMatchers(HttpMethod.DELETE, "/vehicles/**").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .apply(new JwtConfigurer(jwtTokenProvider));
    }
}
