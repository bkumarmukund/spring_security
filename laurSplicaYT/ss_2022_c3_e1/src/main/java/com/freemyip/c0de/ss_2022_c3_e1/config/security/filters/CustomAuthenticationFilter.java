package com.freemyip.c0de.ss_2022_c3_e1.config.security.filters;

import java.io.IOException;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.freemyip.c0de.ss_2022_c3_e1.config.security.authentication.CustomAuthentication;
import com.freemyip.c0de.ss_2022_c3_e1.config.security.managers.CustomAuthenticationManager;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Component
@AllArgsConstructor
@Log4j2
public class CustomAuthenticationFilter extends OncePerRequestFilter {

    private final CustomAuthenticationManager customAuthenticationManager;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain)
            throws ServletException, IOException {

        // create an authentication object which is not yet authenticated

        // delegate the authentication object to the manager

        // get back the authentication from the manager

        // if the object is authenticated then send request to the next filter chain

        String key = String.valueOf(request.getHeader("key"));

        log.info("received key, value="+key);

        CustomAuthentication ca = new CustomAuthentication(false, key);
        Authentication a = customAuthenticationManager.authenticate(ca);

        if (a.isAuthenticated()) {
            SecurityContextHolder.getContext().setAuthentication(a);
            filterChain.doFilter(request, response); // only when authentication worked
        }

    }

}
