package com.springboot.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

//    get http method
    @GetMapping("/hello-world")
    public String helloWorld(){
        return "Hello World";
    }

}
