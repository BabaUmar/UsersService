package com.amalitech.org.api;

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

import com.amalitech.org.Dtos.UserGroupDTO;
import com.amalitech.org.Entity.UserGroup;
import com.amalitech.org.Service.UserGroupService;


@RestController()
@RequestMapping("/grp")
public class UserGroupController {
	@Autowired
	UserGroupService userGroupService;
	
	
	@PostMapping(path="/add")
	public UserGroup createNewUserGroup(@RequestBody UserGroupDTO groupDto) {
		System.out.println(groupDto.getName());
		UserGroup usergroup = new UserGroup();
		usergroup.setName(groupDto.getName());
		return this.userGroupService.createNewUserGroup(usergroup);
	}
	
	@GetMapping
	public List<UserGroup> getAllUserGroups() {
		return this.userGroupService.getAllUserGroups();
	}

	@PutMapping
	public UserGroup updateUserGroup(@RequestBody UserGroupDTO groupDto) {
		UserGroup usergroup = new UserGroup();
		usergroup.setName(groupDto.getName());
		return this.userGroupService.updateUserGroup(usergroup);
	}
	
	@DeleteMapping("/{id}")
	public void deleteUserGroup(@PathVariable("id") int userGroupId) {
		this.userGroupService.deleteUserGroup(userGroupId);
	}

}
