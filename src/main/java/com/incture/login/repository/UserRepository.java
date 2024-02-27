package com.incture.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.incture.login.entitiy.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {
	
	UserEntity findByEmail(String email);
	
	@Query("select ue from UserEntity ue where name = 1 ")
	UserEntity findByName(String name);
	
	
	@Query(value = "select * from demo_session_user where name=1 and email=2", nativeQuery = true)
	UserEntity findByNameAndEmail(String name, String email);

}
