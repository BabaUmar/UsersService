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

import com.amalitech.org.Entity.Department;
import com.amalitech.org.Service.DepartmentService;


@RestController()
@RequestMapping("/department")
public class DepartmentController {

	@Autowired
	DepartmentService departmentService;
	
	@PostMapping
	public Department createNewDept(@RequestBody Department deptDto) {
		Department department = new Department();
		department.setDepartname(deptDto.getDepartname());
		return this.departmentService.createNewDept(department);
	}
	
	@GetMapping
	public List<Department> getAllDept(){
		return this.departmentService.findAllDept();
	}
	
	@PutMapping
	public Department updateDepartment(@RequestBody Department deptDto) {
		Department department = new Department();
		department.setDepartname(deptDto.getDepartname());
		return this.departmentService.updateDept(department);
	}
	
	@DeleteMapping("/{id}")
	public void deleteUserGroup(@PathVariable("id") int deptart_Id) {
		this.departmentService.deleteDepartment(deptart_Id);
	}

}
