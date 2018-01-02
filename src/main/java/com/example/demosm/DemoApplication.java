package com.example.demosm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EnableJpaRepositories("com.example.demosm")
@SpringBootApplication
// @ImportResource("classpath:conf-atargs.xml")
public class DemoApplication {

    public static void main(String[] args) {
            SpringApplication.run(DemoApplication.class, args);

    }

}
