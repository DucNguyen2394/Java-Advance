package com.thehorde.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thehorde.model.User;
import com.thehorde.repository.UserRepository;

@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	UserRepository uRepository;
	
	@PostMapping
	public User save(@RequestBody User user) {		
		return uRepository.save(user);
	}
	@PutMapping
	public User update(@RequestBody User user) {
		return uRepository.update(user);
	}
	@GetMapping
	public List<Object> showList(){
		return uRepository.findAll();
	}
	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") Long id) {
		uRepository.delete(id);
	}
	
}
