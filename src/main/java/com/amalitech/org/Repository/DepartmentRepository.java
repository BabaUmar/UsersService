package com.amalitech.org.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amalitech.org.Entity.Department;
@Repository
public interface DepartmentRepository extends JpaRepository<Department,Integer> {

}
