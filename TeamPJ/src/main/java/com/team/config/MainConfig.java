package com.team.config;

import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Log4j2
public class MainConfig implements WebMvcConfigurer {
    @Override
    public void addFormatters(FormatterRegistry registry) {
        // 컨버터를 만들어서 넣을 곳
    }

    // bean 주입하고 exchange 메소드 사용하기 위함
    @Bean
    public RestOperations restOperations(){
        return new RestTemplate();
    }
}
