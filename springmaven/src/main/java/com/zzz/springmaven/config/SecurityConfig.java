package com.zzz.springmaven.config;

import com.zzz.springmaven.handler.SecurityAuthSuccessHandler;
import com.zzz.springmaven.handler.SecurityPasswordEncode;
import com.zzz.springmaven.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.SecurityBuilder;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author zhangtianyu
 * @version 1.0
 * @ClassName SecurityConfig
 * @description TODO
 * @date 2021/3/2 14:26
 **/
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private SecurityPasswordEncode securityPasswordEncode;

    @Autowired
    private SecurityAuthSuccessHandler securityAuthSuccessHandler;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(securityPasswordEncode);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
        .authorizeRequests().antMatchers("/api/*").anonymous()
                .antMatchers("/deny/*").denyAll()
                .antMatchers("/admin/*").hasRole("admin")
                .antMatchers("/test/*").permitAll()
                .and()
                .formLogin()
                .loginProcessingUrl("/oauth/login")
                .usernameParameter("username")
                .passwordParameter("password")
                .successHandler(securityAuthSuccessHandler)
                .and()
                .logout()
                .logoutUrl("/oauth/logout");
    }
}
