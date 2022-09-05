package com.example.demo;

import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import io.github.bucket4j.Refill;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;

@RestController
public class GreetingController {

	GreetingService greetingService;
	Bucket bucket;

	public GreetingController(GreetingService greetingService) {
		this.greetingService = greetingService;
		this.bucket = bucket();
	}

	public Bucket bucket(){
		return Bucket.builder()
				.addLimit(Bandwidth.classic(10, Refill.intervally(10, Duration.ofSeconds(30)))) //rate limit
				.addLimit(Bandwidth.classic(5, Refill.intervally(5, Duration.ofSeconds(10)))) //burst limit
				.build();
	}

	@GetMapping("/hello")
	public ResponseEntity sayHello() {
		System.out.println("calling controller method");
		if( bucket.tryConsume(1) ) {
			return ResponseEntity.ok(greetingService.sayHello());
		}
		return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS).body("Rate limit exceeded");
	}

	@GetMapping("/hello-secured")
	public ResponseEntity sayHelloSecured() {
		System.out.println("calling controller method");
//		if( bucket.tryConsume(1) ) {
//			return ResponseEntity.ok(greetingService.sayHello());
//		}
		return ResponseEntity.status(HttpStatus.OK).body("Secured endpoint called");
	}
}
