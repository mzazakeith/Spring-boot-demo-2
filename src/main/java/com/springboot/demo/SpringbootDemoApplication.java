package com.springboot.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//This annotation has springbootconfiguration+ enable auto configuration + component scan annotations
//component scan annotation scans all spring components within base package plus all sub packages 
//add @component to classes to create spring component
//We can also use @configuration in a java class and use spring based configurations in the normal class
public class SpringbootDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDemoApplication.class, args);
	}

}
