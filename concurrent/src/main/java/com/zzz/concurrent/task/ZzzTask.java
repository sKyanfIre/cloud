package com.zzz.concurrent.task;

/**
 * 类描述: TODO
 *
 * @author zhangtianyu
 * @date 2022/2/14 3:24 PM
 **/
public class ZzzTask implements Runnable {
    private String name;

    public ZzzTask(String name) {
        this.name = name;
    }

    public ZzzTask(Integer name) {
        this.name = String.valueOf(name);
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " exec zzzTask name = " + name + " ... ");
    }
}
