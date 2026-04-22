package com.example.filter;

import com.example.utils.JwtUtils;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
//@WebFilter(urlPatterns = "/*")
@Slf4j
public class TokenFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String requestURI = request.getRequestURI();
        log.info("请求的URI {}" , requestURI);
        if (requestURI.contains("/login")) {
            log.info("登录请求");
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
            String token = request.getHeader("token");
            if (token == null || token.isEmpty()) {
                log.info("token为空");
                response.setStatus(401);
                return;
            }
            try {
                JwtUtils.parseJwt(token);
            } catch (Exception e) {
                log.info("token解析失败");
                response.setStatus(401);
                return;
            }
            log.info("token解析成功,合法");
            filterChain.doFilter(servletRequest, servletResponse);

    }
}
