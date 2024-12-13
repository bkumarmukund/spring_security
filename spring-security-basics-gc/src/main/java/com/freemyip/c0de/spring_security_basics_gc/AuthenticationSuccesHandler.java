package com.freemyip.c0de.spring_security_basics_gc;

import java.io.IOException;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AuthenticationSuccesHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws ServletException, IOException {
        
        boolean isAdmin = authentication.getAuthorities().stream()
                .anyMatch(g->g.getAuthority().equals("ROLE_ADMIN"));
        
        if(isAdmin)
                setDefaultTargetUrl("/admin/home");
        else
                setDefaultTargetUrl("/user/home");

        super.onAuthenticationSuccess(request, response, authentication);
    }
    
}
