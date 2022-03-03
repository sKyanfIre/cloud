package com.jerry.io.bio.server;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 类描述: TODO
 *
 * @author zhangtianyu
 * @date 2022/2/28 11:20 AM
 **/
@Slf4j
public class JerryMouse {
    @SneakyThrows
    public static void main(String[] args) {
        ExecutorService requestPool = Executors.newFixedThreadPool(16);
        try (ServerSocket serverSocket = new ServerSocket(11111)) {
            log.info("jerry start success...");
            while (true) {
                Socket accept = serverSocket.accept();
                requestPool.submit(new PongCommand(accept));
            }

        } catch (IOException e) {
            log.error("Jerry start failed {}", e);
        }
    }

    public static class PongCommand implements Runnable {
        private Socket accept;

        public PongCommand(Socket socket) {
            this.accept = socket;
        }

        @SneakyThrows
        @Override
        public void run() {
            try (
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(accept.getInputStream()));
                    PrintWriter printWriter = new PrintWriter(accept.getOutputStream())) {
                log.info("jerry readline {}", bufferedReader.readLine());
                Thread.sleep(1000);
                printWriter.println("pong");
                printWriter.flush();
            } finally {
                accept.close();
            }
        }
    }

}
