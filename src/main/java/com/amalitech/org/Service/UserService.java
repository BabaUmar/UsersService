package com.amalitech.org.Service;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amalitech.org.Dtos.UserDTO;
import com.amalitech.org.Entity.Department;
import com.amalitech.org.Entity.User;
import com.amalitech.org.Entity.UserGroup;
import com.amalitech.org.Repository.DepartmentRepository;
import com.amalitech.org.Repository.UserGroupRepository;
import com.amalitech.org.Repository.UserRepository;

@Service
public class UserService {
	@Autowired
   UserRepository userRepository;

	@Autowired
	UserGroupRepository userGroupRepository;
	@Autowired
	DepartmentRepository departmentRepository;
	

	public User getSingleUser(int userId) {
		 return this.userRepository.findById(userId).orElseThrow();
	 }
	 
	public List<User> getAllUsers(){
		return (List<User>) this.userRepository.findAll();
	}
	
//	 public User addNewUsers(UserDTO userDto) {
////		 UserGroup userGroup = this.userGroupRepository.findById(userDto.groupId).orElseThrow();
//	//	 Department depart =   this.departmentRepository.findById(userDto.deptId).orElseThrow();
//		// User user = new User(userDto.id, userDto.username, userDto.emailAddress,userGroup,depart);
//		 UserGroup userGroup = this.userGroupRepository.findById(userDto.groupId).get();
//		 Department depart = this.departmentRepository.findById(userDto.deptId).get();
//		 User user = new User(userDto.getId(),userDto.getUsername(),userDto.getEmailAddress(),userGroup,depart);
//	     return this.userRepository.save(user); 
//	 
//	 }
	
	public User createNewUser(UserDTO userDTO) {
		UserGroup userGroup = this.userGroupRepository.findById(userDTO.groupId).get();
		System.out.println(userGroup);
		Department dept = this.departmentRepository.findById(userDTO.deptId).get();
		User user = new User(userDTO.username,userDTO.emailAddress, userGroup, dept);
		return this.userRepository.save(user);
	}

	
	 public User updateUsers(UserDTO userDto) {
		 UserGroup userGroup = this.userGroupRepository.findById(userDto.groupId).orElseThrow();
		 Department depart =   this.departmentRepository.findById(userDto.deptId).orElseThrow();
		 User user = new User(userDto.emailAddress,userDto.username, userGroup,depart);
	     return this.userRepository.save(user); 
	 
	 }
	 
	 public List<User> findAllUsers() {
		 return this.userRepository.findAll();
		  
	 }
	 public List<User> findUser(String user) {
		 return this.userRepository.findByName(user);
	 }
	 
	 public List<User> findUsersByDept(int deptId){
		 return this.userRepository.findByDeptId(deptId);
	 }
	 
	 public List<User> findUsersByGroup(int groupId){
		 return this.userRepository.findByGroupId(groupId);
	 }
	  
	
	
public void deleteUser(int userId) {
		
		this.userRepository.deleteById(userId);
}
}
