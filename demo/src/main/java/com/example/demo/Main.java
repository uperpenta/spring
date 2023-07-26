package com.example.demo;

import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Main{
    public static void main(String[] args){
        SpringApplication.run(Main.class, args);
    }
    
    @GetMapping("/greet")
    public GreetResponse greet(){
        return new GreetResponse(
            "hello",
            List.of("java","GOlang","javascript"),
            new Person("alex",28,30000));
    }

    record Person(String name,int age,int money){

    }

    record GreetResponse(
        String greet,
        List<String> favp,
        Person person
        ){}


    
}