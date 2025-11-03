package com.example.restservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class RestServiceApplication {

    public static void main(String[] args)   {
        SpringApplication.run(RestServiceApplication.class, args);
    }



    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
            System.out.println("Let's see the beans provided by Spring Boot:");
            String [] beans=ctx.getBeanDefinitionNames();
            Arrays.sort(beans);
            for (String bean : beans) {
                System.out.println(bean);
            }
            System.out.println(ctx.getBeanDefinitionCount());
        };
    }

}
