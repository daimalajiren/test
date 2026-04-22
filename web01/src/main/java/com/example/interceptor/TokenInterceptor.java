package com.example.interceptor;

import com.example.utils.JwtUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
@Slf4j
@Component
public class TokenInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        String requestURI = request.getRequestURI();
//        log.info("请求的URI {}" , requestURI);
//        if (requestURI.contains("/login")) {
//            log.info("登录请求");
//
//            return true;
//        }
        String token = request.getHeader("token");
        if (token == null || token.isEmpty()) {
            log.info("token为空");
            response.setStatus(401);
            return false;
        }
        try {
            JwtUtils.parseJwt(token);
        } catch (Exception e) {
            log.info("token解析失败");
            response.setStatus(401);
            return  false;
        }
        log.info("token解析成功,合法");
        return true;
    }
}
