package com.AJJ.Radio.Controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.AJJ.Radio.Entity.User;
import com.AJJ.Radio.Service.UserService;

@RestController
public class UserController {

	final UserService userService;
	
	public UserController(UserService userService) {
	this.userService=userService;
	}
	
	@GetMapping("/get-user")
	public List<User> getall(){
		return userService.getall();
	}
	
	@GetMapping("/get-user/{id}")
	public User getbyId(@PathVariable Long id){
		return userService.getbyId(id);
	}
	
	@PostMapping("/create-user")
	public ResponseEntity<String> createUser(@RequestBody User user){
		String save=userService.createUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(save);
	}
	
	@PutMapping("/update-user/{id}")
	public ResponseEntity<String> updateUser(@PathVariable Long id,@RequestBody User user){
		String update=userService.createUser(user);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(update);
	}
	
	@DeleteMapping("/delete-user/{id}")
	public void deleteUser(@PathVariable Long id) {
		userService.deleteUser(id);
	}
	
}
