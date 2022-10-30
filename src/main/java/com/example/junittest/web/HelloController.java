package com.example.junittest.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.junittest.web.dto.HelloRespDto;

@RestController
public class HelloController {

	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}

	@GetMapping("/hello/dto")
	public HelloRespDto helloDto(@RequestParam("name") String name, @RequestParam("amount") int amount) {
		return new HelloRespDto(name, amount);
	}
}
