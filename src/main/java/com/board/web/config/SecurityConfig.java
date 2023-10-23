package com.board.web.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@RequiredArgsConstructor
@EnableWebSecurity
@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.authorizeRequests()
                .antMatchers(PERMIT_NORMAL_PATH).permitAll()
//                .antMatchers(HttpMethod.DELETE, "crontab_path").permitAll()
                .anyRequest().authenticated()
                //.and().httpBasic()
                .and().cors()
                .and().csrf().disable()//.csrfTokenRepository(new LazyCsrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()))
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .and().addFilterBefore(new JwtAuthenticationFilter(BeanSuppliers.beanSupplier(context, JwtTokenProvider.class)), UsernamePasswordAuthenticationFilter.class)
                .and().build();
    }

    public static final String[] PERMIT_AUTH_PATH = {
            "/api/auth/**"
    };

    public static final String[] PERMIT_NORMAL_PATH = {
            "/api/**"
    };
}
