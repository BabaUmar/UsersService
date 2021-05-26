package com.amalitech.org.api;
import org.springframework.web.bind.annotation.RestController;

import com.amalitech.org.Dtos.UserDTO;
import com.amalitech.org.Entity.Department;
import com.amalitech.org.Entity.User;
import com.amalitech.org.Entity.UserGroup;
import com.amalitech.org.Service.UserService;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.web.bind.annotation.DeleteMapping;
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
	
	@PostMapping("/add")
	public User createNewUser(@RequestBody UserDTO userDTO) {
		System.out.println(userDTO.username);
		return userService.createNewUser(userDTO);
	}
	
	@GetMapping
	 public List<User> getAllUsers() {
		 return this.userService.getAllUsers();
		  
	 }
	
@GetMapping("/username")
	 public List<User> findUser(@RequestParam String user) {
		System.out.println(this.userService.findUser(user));
		 return this.userService.findUser(user);	 
 }
	
	@GetMapping("/userdept")
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
	
	
	@PutMapping
	public User updateUsers(@RequestBody UserDTO usersDto) {
		return this.userService.updateUsers(usersDto);
	}
	
	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable("id") int userId) {
		this.userService.deleteUser(userId);
	}
	
//@PostMapping()
}
	


