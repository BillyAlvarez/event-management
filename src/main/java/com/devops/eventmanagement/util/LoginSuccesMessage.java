package com.devops.eventmanagement.util;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.FlashMap;
import org.springframework.web.servlet.support.SessionFlashMapManager;

import java.io.IOException;

@Component
public class LoginSuccesMessage extends SimpleUrlAuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        SessionFlashMapManager manager = new SessionFlashMapManager();
        FlashMap flashMap = new FlashMap();

        flashMap.put("success", "Welcome, you have logged in successfully");
        manager.saveOutputFlashMap(flashMap, request, response);

        super.onAuthenticationSuccess(request, response, authentication);
    }
}
