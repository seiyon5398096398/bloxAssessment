package com.blox.questions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Question4Controller {
	
	@Autowired
	private RateLimiterService rateLimiterService;
	
	@GetMapping("/api/callme")
	public String call_me(@RequestParam String input)
	{
		return rateLimiterService.callApi(input);
	}

}
