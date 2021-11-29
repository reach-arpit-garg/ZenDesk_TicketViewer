package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RestController;

import com.model.response;
import com.model.ticketModel;
import com.tickets.tickets;

@ComponentScan(basePackageClasses=tickets.class)
@ComponentScan(basePackageClasses=ticketModel.class)
@ComponentScan(basePackageClasses=response.class)
@SpringBootApplication
@RestController
public class app {
    public static void main(String[] args) {
        SpringApplication.run(app.class, args);
    }
}
