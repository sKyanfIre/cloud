package com.zzz.springmaven.handler;

import com.zzz.springmaven.model.base.PackVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author zhangtianyu
 * @version 1.0
 * @ClassName SecurityAuthSuccessHandler
 * @description TODO
 * @date 2021/3/2 18:29
 **/
@Component
@Slf4j
public class SecurityAuthSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        log.info("登录成功");
        httpServletResponse.getWriter().write(new PackVo().toString());
    }
}
