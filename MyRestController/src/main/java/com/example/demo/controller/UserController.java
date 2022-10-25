package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.example.demo.Exception.ResourceNotFoundException;
import com.example.demo.Model.User;
import com.example.demo.repository.UserRepository;

@RestController
@RequestMapping("/api/v1")
public class UserController 
{
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("/users")
	public User createUser(@Valid @RequestBody User user)
	{
		return userRepository.save(user);
	}
	
	@GetMapping("/users")
	public List<User> getAllUsers()
	{
		return userRepository.findAll();
	}
	
	@GetMapping("/users/{id}")
	
	public ResponseEntity<User> getUserById(@PathVariable(value = "id")Long userId) throws ResourceNotFoundException
	{
		User user=userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("User not Found"+userId));
		return ResponseEntity.ok().body(user);
	}
	
	@PutMapping("/users/{id}")
	
	public ResponseEntity<User> updateUser(@PathVariable(value = "id")Long userId,@Valid @RequestBody User userDetails)throws ResourceNotFoundException
	{
		User user=userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("User Not Found::"+userId));
		
		user.setEmailId(userDetails.getEmailId());
		user.setFirstName(userDetails.getFirstName());
		user.setLastName(userDetails.getLastName());
		user.setUpdatedAt(new Date());
		final User updatedUser=userRepository.save(user);
		return ResponseEntity.ok().body(updatedUser);
		
	}
	
	@DeleteMapping("/users/{id}")
	
	public Map<String, Boolean>deleteUser(@PathVariable(value="id")Long userId)throws ResourceNotFoundException
	{
		User user=userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("User Not Found::"+userId));
		userRepository.delete(user);
		Map<String,Boolean>response=new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	
	

}
