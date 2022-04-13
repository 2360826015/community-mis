package com.liuwohe.communitymis.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/*系统配置类*/
@Configuration
public class AppConfig extends WebMvcConfigurationSupport {

    /*处理跨域请求*/
    @Override
    protected void addCorsMappings(CorsRegistry registry) {
        System.out.println("----------------------");
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowCredentials(true)
                .allowedMethods("GET", "POST")
                .maxAge(3600);
    }
}

