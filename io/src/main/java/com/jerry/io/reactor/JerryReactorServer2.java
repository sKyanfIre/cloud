package com.jerry.io.reactor;

/**
 * 类描述: TODO
 *
 * @author zhangtianyu
 * @date 2022/3/3 7:38 PM
 **/
public class JerryReactorServer2 {
    public static void main(String[] args) {
        new Reactor(11111, false).run();
    }
}
