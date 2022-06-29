package br.com.digisystem.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.digisystem.entities.primary.User;
import br.com.digisystem.repositories.primary.UserRepository;

@RestController
@RequestMapping("/primary")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping
	public List<User> getAll(){
		return userRepository.findAll();
	}
	

}
