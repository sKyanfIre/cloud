package com.zzz.simplespringboot.service;

import org.springframework.stereotype.Service;

/**
 * 类描述: TODO
 *
 * @author zhangtianyu
 * @date 2022/2/10 3:08 PM
 **/

@Service
public class MyService implements IService{
    @Override
    public void test() {
        System.out.println("my service test.....");
    }
}
