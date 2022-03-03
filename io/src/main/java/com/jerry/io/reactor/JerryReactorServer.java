package com.jerry.io.reactor;

/**
 * 类描述: TODO
 *
 * @author zhangtianyu
 * @date 2022/3/3 5:43 PM
 **/
public class JerryReactorServer {
    public static void main(String[] args) {
        new Reactor(11111).run();
    }
}
