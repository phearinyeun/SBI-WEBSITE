package com.sbilh.bank.SBIWEBSITE.configh;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Component;

@Configuration
@EnableWebSecurity
public class LoginSecurityConfig {

    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager(){
        UserDetails user = User.withUserDetails("user")
                .password()
                .passwordEncoder()
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http
//                .csrf().disable()
//                .authorizeRequests()
//                .antMatchers("/login/**")
//                .permitAll()
//                .anyRequest()
//                .authenticated()
//                .and()
                .formLogin()
                .loginPage("/login.html")
                .loginProcessingUrl("/login.html")
                .defaultSuccessUrl("/registration.html", true)
                .failureUrl("/login.html?error=true");
        return http.build();
    }

}
