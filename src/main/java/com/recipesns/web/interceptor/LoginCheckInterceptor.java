package com.recipesns.web.interceptor;

import com.recipesns.web.exception.BusinessError;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.HandlerInterceptor;

public class LoginCheckInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();

        if (session == null || session.getAttribute("loginMember") == null) {
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            throw BusinessError.MEMBER_LOGIN_ERROR.exception();
        }
        return true;
    }
}
