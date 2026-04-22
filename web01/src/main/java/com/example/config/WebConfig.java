package com.example.config;


import com.example.interceptor.DemoInterceptor;
import com.example.interceptor.TokenInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration //包含了component
public class WebConfig implements WebMvcConfigurer{
//    @Autowired
//    DemoInterceptor demoInterceptor;

    @Autowired
    TokenInterceptor tokenInterceptor;
    @Override
   public void addInterceptors(InterceptorRegistry  registry)
        {
            registry.addInterceptor(tokenInterceptor)
                    .addPathPatterns("/**")
                    .excludePathPatterns("/login");
        }
}
