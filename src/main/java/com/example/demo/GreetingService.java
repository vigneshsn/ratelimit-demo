package com.example.demo;

import org.springframework.stereotype.Service;

@Service
public class GreetingService {
	public String sayHello() {
		return "Hello!";
	}
}