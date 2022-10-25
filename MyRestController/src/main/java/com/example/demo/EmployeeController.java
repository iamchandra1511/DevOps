package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class EmployeeController 
{
	@GetMapping("/MyRequest")
	
	public String MyMessage()
	{
		return "Response from the Controller";
	}

}
