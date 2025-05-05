package com.AJJ.Radio.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.AJJ.Radio.Entity.User;
import com.AJJ.Radio.Repository.UserRepo;

@Service
public class UserService {
	final UserRepo userRepo;

	public UserService(UserRepo userRepo) {
		this.userRepo = userRepo;
	}

	public List<User> getall() {
		return userRepo.findAll();
	}

	public User getbyId(long id) {
		User user = userRepo.findById(id).orElseThrow(() -> new RuntimeException("User based on that id is not there"));
		return user;
	}

	public String createUser(User user) {
		userRepo.save(user);
		return "User has been saved";
	}

	public String updateUser(Long id, User user) {
		Optional<User> users = userRepo.findById(id);
		user.setName(user.getName());
		user.setTechnology(user.getTechnology());
		user.setEmail(user.getEmail());
		return "User have been Updated";
	}

	public void deleteUser(Long id) {
		userRepo.deleteById(id);
	}
}
