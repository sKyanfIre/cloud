package com.zzz.springmaven.service;

import com.zzz.springmaven.mapper.UserMapper;
import com.zzz.springmaven.model.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author zhangtianyu
 * @version 1.0
 * @ClassName UserServiceImpl
 * @description TODO
 * @date 2021/3/2 15:09
 **/
@Service
public class UserServiceImpl implements UserDetailsService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserDetails userDetails = userMapper.queryUserByUsername(s);
        if(userDetails == null) {
            throw new UsernameNotFoundException("用户不存在");
        }
        return userDetails;
    }

    public void register(UserVo userVo) {
        //TODO 注册
//        userMapper.save()
    }
}
