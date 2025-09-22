package com.example.demo.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurity {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http    .csrf(csrf->csrf.disable())
                .authorizeHttpRequests(auth->auth
                .requestMatchers("/","/login","/register").permitAll()
                .anyRequest().authenticated()
        ).formLogin(f->f
                .loginPage("/html/login")
                .defaultSuccessUrl("/html/dashboard", true)
                .permitAll());

        return http.build();

    }


    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}



