package com.amalitech.org.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amalitech.org.Entity.UserGroup;
import com.amalitech.org.Repository.UserGroupRepository;

@Service
public class UserGroupService {
	@Autowired
	UserGroupRepository userGroupRepository;
	

	public UserGroup createNewUserGroup(UserGroup group) {
		return this.userGroupRepository.save(group);
	}
	
	public List<UserGroup> getAllUserGroups() {
		return this.userGroupRepository.findAll();
	}
	
	
	public UserGroup updateUserGroup(UserGroup group) {
		return this.userGroupRepository.save(group);
	}
	 public void deleteUserGroup(int usergroupId) {
			this.userGroupRepository.deleteById(usergroupId); 
		 }

}
