package com.dockerdemoapp.dockerdemoapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DockerDemoAppApplication
{
    @GetMapping("/message")
    public String getMessage()
    {
       return "Hello World";
    }

    public static void main(String[] args)
    {
        SpringApplication.run(DockerDemoAppApplication.class, args);
        System.out.println("Hello working");

    }

}
