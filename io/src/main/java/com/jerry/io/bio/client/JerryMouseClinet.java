package com.jerry.io.bio.client;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 类描述: TODO
 *
 * @author zhangtianyu
 * @date 2022/2/28 11:49 AM
 **/
@Slf4j
public class JerryMouseClinet {
    @SneakyThrows
    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();
        ExecutorService executorService = Executors.newFixedThreadPool(16);
        for (int i = 0; i < 10000; i++) {
            executorService.submit(new PingCommand());
        }
        executorService.shutdown();
        long end = System.currentTimeMillis();
        Thread.sleep(3000);
        log.info("cost {} ms", end - start);
//        new PingCommand().run();
    }

    public static class PingCommand implements Runnable {

        @SneakyThrows
        @Override
        public void run() {
            try (
                    Socket socket = new Socket("localhost", 11111);
                    PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
                printWriter.println("hello jerry");
                printWriter.flush();
                log.info("jerry client receive msg: {}", bufferedReader.readLine());
            }
        }
    }
}
