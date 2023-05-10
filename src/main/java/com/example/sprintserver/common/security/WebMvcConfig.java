package com.example.sprintserver.common.security;

import com.example.sprintserver.user.jwt.JwtUtil;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebMvcConfig implements WebMvcConfigurer {
    private final static String CLIENT_URL = "http://43.200.169.48:3000/";

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:3000", CLIENT_URL)
                .allowedMethods("OPTIONS", "GET", "POST", "PUT", "DELETE")
                .exposedHeaders(JwtUtil.AUTHORIZATION_HEADER)
                .allowCredentials(true);
    }
}
