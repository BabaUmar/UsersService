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
	

	public UserService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	public User getSingleUser(int userId) {
		 return this.userRepository.findById(userId).orElseThrow();
	 }
	 
	
	public List<User> getAllUsers(){
		return this.userRepository.findAll();
	}
	public List<User> getUser(String user){
		return this.userRepository.findByName(user);
		
	}
	 public List<User> findUsersByDept(int deptId){
		 return this.userRepository.findByDeptId(deptId);
	 }
	 public List<User> findUsersByGroup(int groupId){
		 return this.userRepository.findByGroupId(groupId);
	 }
	 


	
	public User addNewUser(UserDTO userDto) {
		User user = new User(userDto.getId(),userDto.getEmailAddress(),userDto.getUsername());
		UserGroup userGroup = this.userGroupRepository.findById(userDto.deptId).orElseThrow();
		Department department =   this.departmentRepository.findById(userDto.deptId).orElseThrow();
		return this.userRepository.save(user);
		
	}
	
	public User updateUser(UserDTO userDto) {
		User user = new User(userDto.getId(),userDto.getEmailAddress(),userDto.getUsername());
		UserGroup userGroup = this.userGroupRepository.findById(userDto.groupId).orElseThrow();
		 Department department =   this.departmentRepository.findById(userDto.deptId).orElseThrow();
		return this.userRepository.save(user);
	}
	
public void deleteUser(int userId) {
		
		this.userRepository.deleteById(userId);
}
}
