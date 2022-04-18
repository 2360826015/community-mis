package com.liuwohe.communitymis.config;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;


/*系统配置类*/
@MapperScan("com.liuwohe.communitymis.mapper")
@Configuration
public class AppConfig extends WebMvcConfigurationSupport {

    /*处理跨域请求*/
    @Override
    protected void addCorsMappings(CorsRegistry registry) {
        System.out.println("----------------------");
        registry.addMapping("/**")
                .allowedOriginPatterns("*")
                .allowCredentials(true)
                .allowedMethods("GET", "POST")
                .maxAge(3600);
    }

}

