package com.jeananani.immosmart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ImmoSmartApplication {

    public static void main(String[] args) {
        SpringApplication.run(ImmoSmartApplication.class, args);
    }

}
