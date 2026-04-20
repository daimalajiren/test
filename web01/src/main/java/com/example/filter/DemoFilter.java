package com.example.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
@Slf4j
//@WebFilter(urlPatterns = "/*")
public class DemoFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
        log.info("DemoFilter init..................");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("DemoFilter doFilter..................");
        //放行
        filterChain.doFilter(servletRequest,servletResponse);

        log.info("DemoFilter doFilter end..................");

    }

    @Override
    public void destroy() {
        Filter.super.destroy();
        log.info("DemoFilter destroy..................");
    }
}

