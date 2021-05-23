package com.amalitech.org.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amalitech.org.Entity.Department;
import com.amalitech.org.Repository.DepartmentRepository;

@Service
public class DepartmentService {
	
	@Autowired
	DepartmentRepository departmentRepository;
	
	
	public Department createNewDept(Department department) {
		return this.departmentRepository.save(department);
	}
	
	public List<Department> findAllDept(){
		return this.departmentRepository.findAll();
	}
	
	
	 public void deleteDepartment(int deptId) {
			this.departmentRepository.deleteById(deptId); 
		 }
	 

		public Department updateDept(Department department) {
			return this.departmentRepository.save(department);
		}
		

}
