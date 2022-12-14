package com.sbilh.bank.SBIWEBSITE.configh;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails user = User.withUsername("admin")
                .password(passwordEncoder().encode("userPass"))
                .roles("USER")
                .build();
        UserDetails admin = User.withUsername("admina")
                .password(passwordEncoder().encode("adminPass"))
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user,admin);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain (HttpSecurity http) throws Exception{
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers( "login/**", "/login", "/BranchesModel/**", "/register/**","/home/**")
                .permitAll().anyRequest().authenticated()
                .and()

                .formLogin(Customizer.withDefaults())
                .formLogin(loginConfig -> {
                    loginConfig
                            .loginPage("/login")
                            .loginProcessingUrl("/login")
                            .defaultSuccessUrl("/BranchesModel")
                            .permitAll();
                })
                .logout().deleteCookies("JSESSIONID") .logoutSuccessUrl("/login?logout");
        return http.build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer(){
        return web -> web.ignoring()
                .antMatchers("/static/**")
                .antMatchers("/favicon.ico")
                .antMatchers("/assets/**")
                .antMatchers("/css/**")
                .antMatchers("/img/**")
                .antMatchers("/js**")
                .antMatchers("/admin/**")
                .antMatchers("/webjars/**")
                .antMatchers("/templates/**");
    }
}
