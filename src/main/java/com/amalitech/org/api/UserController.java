package com.amalitech.org.api;
import org.springframework.web.bind.annotation.RestController;

import com.amalitech.org.Dtos.UserDTO;
import com.amalitech.org.Entity.User;
import com.amalitech.org.Service.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	 UserService userService;
	
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	

	
	@GetMapping
	public List<User> getAllUsers(){
		return this.userService.getAllUsers();
	}
	
	@GetMapping("/username")
	 public List<User> findByUser(@RequestParam String user) {
		 return this.userService.getUser(user);	 
	 }
	
	@GetMapping("/userdepartment")
	 public List<User> findUserByDept(@RequestParam int deptId) {
		 return this.userService.findUsersByDept(deptId); 
	 }
	
	@GetMapping("/getusergroup")
	 public List<User> findUserByGroup(@RequestParam int groupId) {
		 return this.userService.findUsersByGroup(groupId); 
	 }
	
	
	
	@GetMapping("/{id}")
	public User getSingleUser(@PathVariable ("id") int userId) {
		
		return this.userService.getSingleUser(userId);
		
	}

	@PostMapping
	public User addNewUser(@RequestBody UserDTO userDto) {
		return this.userService.addNewUser(userDto);
	}
	
	@PutMapping
	public User updateUser(@RequestBody UserDTO userDto) {
		return this.userService.updateUser(userDto);
	}
}
