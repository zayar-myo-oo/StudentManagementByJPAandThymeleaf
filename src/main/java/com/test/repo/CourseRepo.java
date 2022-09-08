package com.test.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.test.dto.CourseRes;


@Repository
public interface CourseRepo extends CrudRepository<CourseRes,Integer> {

	@Query(value = "select max(cid) as maxid from course",nativeQuery = true)
	int courseMaxid();
	
	
	@Query(value = "select c.* from student s join coursedetail cd on s.sid = cd.studentid join \r\n"
			+ "course c on c.cid = cd.courseid where s.sid = :id ",nativeQuery = true) 
	List<CourseRes> getcourseofspecifci(Integer id ); 

	
	
}
