package com.sbilh.bank.SBIWEBSITE.configh;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@Component
public class JwtAthFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain) throws ServletException, IOException {
        final String authHeader = request.getHeader(AUTHORIZATION) ;
        final String userEmail;
        final String jwtToken;

        if (authHeader == null || !authHeader.startsWith("Bearer")){
            filterChain.doFilter(request, response);
            return;
        }
        jwtToken = authHeader.substring(7);
        userEmail = "fds"; //TODO to be impletmented
//        if (userEmail != null && SecurityContextHolder.getContext().getAuthentication() == null);
//            UserDetails userDetails = userDetailsService.loadUserByUsername(userEmail);
//            final boolean isTokenValid; //TODO tobe impletement
//        if (isTokenValid){
//            UsernamePasswordAuthenticationToken authtoken =
//                    new UsernamePasswordAuthenticationToken(userDetails, null);
//            authtoken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//            SecurityContextHolder.getContext().setAuthentication(authtoken);
//        }
        filterChain.doFilter(request, response);
    }
}
