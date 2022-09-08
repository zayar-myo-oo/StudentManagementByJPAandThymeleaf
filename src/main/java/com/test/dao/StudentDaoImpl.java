package com.test.dao;

import java.util.ArrayList;
import java.util.List;

// import javax.persistence.EntityManager;
// import javax.persistence.EntityManagerFactory;
// import javax.persistence.Persistence;
// import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

// import com.test.dto.CourseRes;
// import com.test.dto.StudentReq;
import com.test.dto.StudentRes;
// import com.test.repo.CourseRepo;
import com.test.repo.StudentRepo;

@Service
public class StudentDaoImpl implements StudentDao {

	@Autowired
	StudentRepo repo;

	@Autowired
	CourseDaoImpl dao;
	// CourseDao dao;

	@Override
	public void insertStudent(StudentRes res) {

		repo.save(res);
	}

	@Override
	public int studentMaxID() {

		return repo.MaxStuID();
	}

	@Override
	public List<StudentRes> showStudent() {
		List<StudentRes> a = repo.findall();
		List<StudentRes> f = new ArrayList<>();
		for (StudentRes b : a) {
			StudentRes res = b;
			for (String g : repo.findcourse(b.getId()))
				res.setCourse(g);
			f.add(res);
		}
		return f;
	}

	@Override
	public List<StudentRes> specificStudent(StudentRes res) {

		if (res.getId() != 0 && !res.getName().equals("") &&
				!res.getCourse().equals("")) {
			List<StudentRes> a = repo.specific(res.getId(), res.getName(), res.getCourse());
			List<StudentRes> f = new ArrayList<>();
			for (StudentRes b : a) {
				StudentRes re = b;
				for (String g : repo.findcourse(b.getId()))
					re.setCourse(g);
				f.add(re);
			}
			return f;

		}
		List<StudentRes> a = repo.specificwithall(res.getId(), res.getName(), res.getCourse());
		List<StudentRes> f = new ArrayList<>();
		for (StudentRes b : a) {
			StudentRes re = b;
			for (String g : repo.findcourse(b.getId()))
				re.setCourse(g);
			f.add(re);
		}
		return f;

	}

	@Override
	public void updateStudent(StudentRes res) {
		repo.save(res);

	}

	@Override
	public void deleteStudent(StudentRes res) {
		repo.delete(res);

	}

	@Override
	public StudentRes getone(StudentRes res) {
		StudentRes r = repo.getone(res.getId());

		r.setCourseres(dao.getcourseofone(res.getId()));

		return r;
	}

}
