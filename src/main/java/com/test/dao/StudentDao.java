package com.test.dao;

import java.util.List;

// import com.test.dto.StudentReq;
import com.test.dto.StudentRes;

public interface StudentDao {

	void insertStudent(StudentRes res);

	int studentMaxID();

	List<StudentRes> showStudent();

	List<StudentRes> specificStudent(StudentRes res);

	void updateStudent(StudentRes res);

	void deleteStudent(StudentRes res);

	StudentRes getone(StudentRes res);

}
