package com.test.repo;

import java.util.List;

// import javax.persistence.EntityResult;
// import javax.persistence.FieldResult;
// import javax.persistence.NamedNativeQuery;
// import javax.persistence.SqlResultSetMapping;

// import org.hibernate.annotations.SqlFragmentAlias;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.test.dto.StudentRes;

@Repository
public interface StudentRepo extends CrudRepository<StudentRes, Integer> {

	@Query(value = "select max(sid) as maxid from student", nativeQuery = true)
	int MaxStuID();

	@Query(value = "select * from student where sid = :id", nativeQuery = true)
	List<StudentRes> findByid(int id);

	@Query(value = "select s.* from student s join coursedetail cd on s.sid = cd.studentid join \r\n"
			+ "course c on c.cid = cd.courseid  group by s.sid", nativeQuery = true)
	List<StudentRes> findall();

	@Query(value = "select group_concat(c.name) as course from student s join coursedetail cd on s.sid = cd.studentid join \r\n"
			+ "course c on c.cid = cd.courseid where s.sid = :i  group by s.sid", nativeQuery = true)
	List<String> findcourse(int i);

	@Query(value = "select s.* from student s join coursedetail cd on s.sid = cd.studentid join \r\n"
			+ "course c on c.cid = cd.courseid where s.sid = :id or s.name = :name or c.name = :cname  group by s.sid", nativeQuery = true)
	List<StudentRes> specificwithall(int id, String name, String cname);

	@Query(value = "select s.* from student s join coursedetail cd on s.sid = cd.studentid join \r\n"
			+ "course c on c.cid = cd.courseid where s.sid = :id and s.name = :name and c.name = :cname  group by s.sid", nativeQuery = true)
	List<StudentRes> specific(int id, String name, String cname);

	@Query(value = "select s.* from student s join coursedetail cd on s.sid = cd.studentid join \r\n"
			+ "course c on c.cid = cd.courseid where s.sid = :id ", nativeQuery = true)
	StudentRes getone(int id);

	// @SqlResultSetMapping( name = "student",
	// entities = {@EntityResult(entityClass = com.test.dto.StudentRes.class,fields
	// = {
	// @FieldResult(name = "id", column = "sid"),
	// @FieldResult(name = "dob", column = "dob"),
	// @FieldResult(name = "education", column = "education"),
	// @FieldResult(name = "gender", column = "gender"),
	// @FieldResult(name = "name", column = "name"),
	// @FieldResult(name = "phone", column = "phone"),
	// @FieldResult(name = "course", column = "course")
	// })})
	//

}
