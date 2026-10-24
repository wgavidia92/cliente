package com.devsu.cliente;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.devsu.cliente.*")
public class ClienteApplication {

    static void main(String[] args) {
        SpringApplication.run(ClienteApplication.class, args);
    }

}
