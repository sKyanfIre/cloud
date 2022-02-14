package com.zzz.simplespringboot.filter;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * 类描述: TODO
 *
 * @author zhangtianyu
 * @date 2022/2/11 4:11 PM
 **/
@Component
public class MySpringWebFilter extends GenericFilterBean {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("mySpringWebFilter is  starting ...");
        chain.doFilter(request, response);
        System.out.println("mySpringWebFilter is  end ...");

    }
}
