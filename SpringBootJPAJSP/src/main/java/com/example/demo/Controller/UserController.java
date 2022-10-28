package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.UserRepository;

@RestController
@RequestMapping("/api/v1")
public class UserController 
{
	
	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/users")
	public String home(Model model)
	{
		model.addAttribute("users", userRepository.findAll());
		//return "users";
		return "Message";
	}

}
