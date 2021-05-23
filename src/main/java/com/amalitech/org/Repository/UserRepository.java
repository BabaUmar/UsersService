package com.amalitech.org.Repository;

import java.util.List;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.amalitech.org.Entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	@Query(value ="SELECT * FROM users WHERE name =?1", nativeQuery = true)
	List<User> findByName(String user);

	@Query(value ="SELECT * FROM users WHERE Department_id =?1", nativeQuery = true)
	List<User> findByDeptId(int deptId);
	
	@Query(value ="SELECT * FROM users WHERE Usergroup_id =?1", nativeQuery = true)
	List<User> findByGroupId(int groupId);


}
