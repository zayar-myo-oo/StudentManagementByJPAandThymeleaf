package com.test.controller;

import java.util.ArrayList;
import java.util.Arrays;
// import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.test.bean.Student;
import com.test.dao.StudentDao;
import com.test.dto.CourseRes;
import com.test.dto.StudentRes;

@Controller
public class StudentController {

	@Autowired
	StudentDao studentdao;

	@GetMapping("/registerStudent")
	public ModelAndView registerStudent() {
		return new ModelAndView("STU001", "student", new Student());
	}

	@PostMapping("/StudentRegister")
	public String processingRegister(@ModelAttribute("student") Student stu, HttpServletRequest request) {

		if (stu.getName().equals("") || stu.getDob().equals("") || stu.getGender().equals("") ||
				stu.getPhone().equals("") || stu.getEducation().equals("") || stu.getAttend() == null) {
			request.setAttribute("error", "fill all the information !! ");
			return "STU001";
		}

		List<CourseRes> b = new ArrayList<>();
		for (String a : stu.getAttend()) {
			String[] g = a.split("-");
			CourseRes res = new CourseRes();
			res.setCid(Integer.valueOf(g[0]));
			res.setName(g[1]);
			b.add(res);
		}

		StudentRes req = new StudentRes();

		req.setId(Integer.valueOf(stu.getId()));
		req.setName(stu.getName());
		req.setDob(stu.getDob());
		req.setGender(stu.getGender());
		req.setPhone(stu.getPhone());
		req.setEducation(stu.getEducation());
		req.setCourseres(b); // somethings
		studentdao.insertStudent(req);
		int i = studentdao.studentMaxID();
		i += 1;
		request.getSession().setAttribute("stuno", i);
		request.getSession().setAttribute("student", studentdao.showStudent());
		return "redirect:/registerStudent";
	}

	@GetMapping("/showuser")
	public ModelAndView showUser(HttpServletRequest request) {
		if (request.getSession().getAttribute("user") == null) {
			return new ModelAndView("redirect:/");
		} else {
			request.getSession().setAttribute("student", studentdao.showStudent());
			return new ModelAndView("STU003", "stu", new Student());
		}

	}

	@PostMapping("/StudentSearch")
	public String searchstudent(@ModelAttribute("stu") Student stu, HttpServletRequest request) {

		StudentRes req = new StudentRes();
		if (stu.getId().equals("") || stu.getId() == null) {
			req.setId(0);
		} else {
			req.setId(Integer.valueOf(stu.getId()));
		}
		req.setName(stu.getName());
		req.setCourse(stu.getCourse());

		if (studentdao.specificStudent(req) == null) {
			return "redirect:/showuser??notfound='not found!!'";
		}
		request.getSession().setAttribute("student", studentdao.specificStudent(req));

		System.out.println(">>>" + req.getId());

		return "STU003";
	}

	@GetMapping("/StudentUpdate/{id}")
	public ModelAndView update(@PathVariable("id") int id, HttpServletRequest request) {
		StudentRes r = new StudentRes();
		r.setId(id);

		StudentRes req = studentdao.getone(r);

		Student stu = Student.builder().id(String.valueOf(req.getId())).name(req.getName())
				.dob(req.getDob()).gender(req.getGender()).phone(req.getPhone())
				.education(req.getEducation()).courseres(req.getCourseres()).build();

		return new ModelAndView("STU002", "stud", stu);
	}

	@PostMapping("/StudentUpdate")
	public String updateProcessing(@ModelAttribute("stud") Student stu, HttpServletRequest request) {

		if (stu.getName().equals("") || stu.getDob().equals("") || stu.getGender().equals("") ||
				stu.getPhone().equals("") || stu.getEducation().equals("") || stu.getAttend() == null) {
			request.setAttribute("error", "fill all the information !! ");
			StudentRes req = new StudentRes();
			req.setId(Integer.valueOf(stu.getId()));

			request.setAttribute("stu", studentdao.specificStudent(req));

			return "STU002";

		}

		List<CourseRes> b = new ArrayList<>();
		for (String a : stu.getAttend()) {

			String[] g = a.split("-");
			CourseRes res = new CourseRes();
			res.setCid(Integer.valueOf(g[0]));
			res.setName(g[1]);
			b.add(res);

		}

		StudentRes req = new StudentRes();

		req.setId(Integer.valueOf(stu.getId()));
		req.setName(stu.getName());
		req.setDob(stu.getDob());
		req.setGender(stu.getGender());
		req.setPhone(stu.getPhone());
		req.setEducation(stu.getEducation());
		req.setCourseres(b);

		studentdao.updateStudent(req);

		request.getSession().setAttribute("student", studentdao.showStudent());
		return "redirect:/showuser";
	}

	@GetMapping("/StudentDelete/{id}")
	public String deleteStudent(@PathVariable("id") int id, HttpServletRequest request) {

		StudentRes req = new StudentRes();
		req.setId(id);

		studentdao.deleteStudent(req);

		request.getSession().setAttribute("student", studentdao.showStudent());
		return "redirect:/showuser";
	}

}
