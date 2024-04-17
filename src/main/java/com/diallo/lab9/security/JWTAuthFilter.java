package com.diallo.lab9.security;


import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@Component

public class JWTAuthFilter extends OncePerRequestFilter {

    @Autowired
    JwtUtilityService jwtUtilityService;


    @Override
    @SuppressWarnings("null")
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        // Look for the Authorizataion header
        String authorizationHeader = request.getHeader("Authorization");
        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        // Extract the JWT token
        String jwtToken = authorizationHeader.substring(7);
        Claims claims = jwtUtilityService.extractAllClaims(jwtToken);
        String username = claims.getSubject();
        Date expiration = claims.getExpiration();
        if (username == null || expiration == null || expiration.before(new Date())) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        // Setup the security context
        @SuppressWarnings("unchecked")
        List<String> roleNames = claims.get("roles", List.class);
        String[] roles = roleNames.toArray(new String[0]);
        UserDetails userDetails = User.withUsername(username)
                .password("doesn't like empty").roles(roles).build();
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(userDetails, null,
                userDetails.getAuthorities());
        token.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(token);

        // Continue the filter chain
        filterChain.doFilter(request, response);
    }

    @Override
    @SuppressWarnings("null")
    protected boolean shouldNotFilter(HttpServletRequest request) {

        // Do not apply the filter to the login URI
        var uri = new AntPathRequestMatcher("/adsweb/api/v1/login");
        return uri.matches(request);
    }


}

