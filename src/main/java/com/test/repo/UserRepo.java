package com.test.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

// import com.test.dto.UserReq;
import com.test.dto.UserRes;

@Repository
public interface UserRepo extends CrudRepository<UserRes, Integer> {

	@Query(value = "select * from user u where u.id=:a and u.password=:b", nativeQuery = true)
	UserRes findByidAndpassword(int a, String b);

	@Query(value = "select * from user u where u.id=:Id", nativeQuery = true)
	List<UserRes> findByid(int Id);

	@Query(value = "select * from user u where u.name=:name ", nativeQuery = true)
	List<UserRes> findByname(String name);

	List<UserRes> findByNameAndId(int Id, String Name);

	List<UserRes> findById(int Id);
}
