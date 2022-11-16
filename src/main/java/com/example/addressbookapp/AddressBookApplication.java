package com.example.addressbookapp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
@Slf4j
//Here context is used to store the configuration of SpringApplication which run with various argument
// from that we are able to get environment and database name
public class AddressBookApplication {

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(AddressBookApplication.class, args);
        log.info("Employee payroll app started in {} Environment " + context.getEnvironment().getProperty("environment"));
        log.info("Employee payroll DB User is {} " + context.getEnvironment().getProperty("spring.datasource.username"));

    }
}