package com.zzz.simplespringboot.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;


/**
 * 类描述: TODO
 *
 * @author zhangtianyu
 * @date 2022/2/11 4:53 PM
 **/
@Component
public class MyJavaFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("MyJavaFilter is starting...");
        chain.doFilter(request, response);
        System.out.println("MyJavaFilter is end...");

    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
