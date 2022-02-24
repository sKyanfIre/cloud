package com.zzz.simplespringboot.filter;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 类描述: TODO
 *
 * @author zhangtianyu
 * @date 2022/2/11 5:03 PM
 **/
@Component
public class MyOncePerRequestFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        System.out.println("MyOncePerRequestFilter is start ...");
        RequestContextHolder.getRequestAttributes();
        filterChain.doFilter(request, response);
        System.out.println("MyOncePerRequestFilter is end ...");

    }
}
