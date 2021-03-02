package com.zzz.springmaven;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.zzz.springmaven.*"})
public class SpringmavenApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringmavenApplication.class, args);
    }

}
