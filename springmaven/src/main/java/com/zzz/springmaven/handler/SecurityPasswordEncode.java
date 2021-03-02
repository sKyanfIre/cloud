package com.zzz.springmaven.handler;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @author zhangtianyu
 * @version 1.0
 * @ClassName SecurityPasswordEncode
 * @description TODO
 * @date 2021/3/2 16:38
 **/
@Component
public class SecurityPasswordEncode implements PasswordEncoder {
    @Override
    public String encode(CharSequence charSequence) {
        return charSequence.toString() + "加密之后的密码";
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return encode(charSequence).equals(s);
    }
}
