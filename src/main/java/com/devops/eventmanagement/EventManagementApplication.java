package com.devops.eventmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class EventManagementApplication implements CommandLineRunner {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(EventManagementApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        String pass1 = "user";
        String pass2 = "admin";
        System.out.println("pass1 = " + bCryptPasswordEncoder.encode(pass1) );
        System.out.println("pass2 = " + bCryptPasswordEncoder.encode(pass2));

    }
}

