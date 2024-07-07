package com.team.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebSecurity
public class SecurityConfig implements WebMvcConfigurer {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.csrf().disable();


        http.formLogin(config -> {
            config.loginPage("/auth/login")
                    .usernameParameter("id")
                    .defaultSuccessUrl("/main");
        });

        http.logout(config -> {
            config.logoutUrl("/auth/logout")
                    .logoutSuccessUrl("/main")
                    .deleteCookies("JSESSIONID") // Cookie 제거
                    .invalidateHttpSession(true) // Session 초기화
                    .clearAuthentication(true)
                    .permitAll();
        });

        http.authorizeHttpRequests(registry -> {
            // /main 경로는 인증이 되어야 한다
//            registry.requestMatchers("/main").authenticated()
            registry.requestMatchers("/product/register_product").permitAll();
            registry.anyRequest().permitAll(); // 그 외 모든 경로는 인증 없이 가능
//            registry.anyRequest().authenticated();

        });



        return http.build();
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public RestOperations restOperations(){
        return new RestTemplate();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer(){
        return web -> web.ignoring().requestMatchers(PathRequest.toStaticResources().atCommonLocations());
    }
}
