package com.amalitech.org.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amalitech.org.Dtos.UserDTO;
import com.amalitech.org.Entity.User;
import com.amalitech.org.Service.UserService;

@RestController
@RequestMapping("/add")
public class NewController {

	@Autowired
	UserService userService;
	
	@PostMapping
	public User createNew(@RequestBody UserDTO userDTO) {	
		return this.userService.createNewUser(userDTO);
	}
}
