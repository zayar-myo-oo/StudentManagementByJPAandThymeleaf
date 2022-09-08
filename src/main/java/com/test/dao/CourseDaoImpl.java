package com.test.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// import com.test.dto.CourseReq;
import com.test.dto.CourseRes;
import com.test.repo.CourseRepo;

@Service
public class CourseDaoImpl implements CourseDao {

	@Autowired
	CourseRepo repo;

	@Override
	public void insertCourse(CourseRes res) {
		repo.save(res);

	}

	@Override
	public int couresMaxid() {

		return repo.courseMaxid();
	}

	@Override
	public List<CourseRes> showCouse() {

		return (List<CourseRes>) repo.findAll();
	}

	@Override
	public List<CourseRes> getcourseofone(Integer i) {

		return repo.getcourseofspecifci(i);
	}

}
