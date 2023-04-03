package com.portfolio.sms.security;

import com.portfolio.sms.security.jwt.JwtEntryPoint;
import com.portfolio.sms.security.jwt.JwtTokenFilter;
import com.portfolio.sms.security.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.validation.constraints.NotNull;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
public class MainSecurity   {
    @Autowired
    UserDetailsServiceImpl userDetailsServiceImpl;
    @Autowired
    JwtEntryPoint jwtEntryPoint;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtTokenFilter jwtTokenFilter;

    AuthenticationManager authenticationManager;


    @Bean
    public SecurityFilterChain filterChain(@NotNull HttpSecurity http) throws Exception {
    AuthenticationManagerBuilder builder = http.getSharedObject( AuthenticationManagerBuilder.class );
    builder.userDetailsService( userDetailsServiceImpl ).passwordEncoder( passwordEncoder );
    authenticationManager = builder.build();
    http.authenticationManager( authenticationManager );

    http.csrf().disable();
    http.cors();
    http.sessionManagement().sessionCreationPolicy( SessionCreationPolicy.STATELESS );

    http.authorizeHttpRequests().requestMatchers( new org.springframework.security.web.util.matcher.RequestMatcher[]{} )
            .permitAll()
            .anyRequest().authenticated();
    http.exceptionHandling().authenticationEntryPoint( jwtEntryPoint );
    http.addFilterBefore( jwtTokenFilter, UsernamePasswordAuthenticationFilter.class );
    return http.build();
    }


}
