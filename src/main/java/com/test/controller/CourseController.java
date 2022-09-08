package com.test.controller;

// import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.beans.factory.annotation.Qualifier;
// import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.test.bean.Course;
import com.test.dao.CourseDao;
import com.test.dto.CourseRes;

@Controller
public class CourseController {

	@Autowired
	CourseDao coursedao;

	@GetMapping("/courseRegister")
	public ModelAndView courseRegister() {

		return new ModelAndView("BUD003", "course", new Course());
	}

	@PostMapping("/CourseRegister")
	public String processingResgister(@ModelAttribute("course") Course course, HttpServletRequest request) {

		if (request.getParameter("id").equals("") || request.getParameter("name").equals("")) {
			request.setAttribute("error", "fill all information");
			return "BUD003";
		}
		CourseRes req = new CourseRes();
		req.setCid(Integer.valueOf(course.getId()));
		req.setName(course.getName());

		coursedao.insertCourse(req);

		int i = (Integer) coursedao.couresMaxid();
		i += 1;
		request.getSession().setAttribute("cid", i);
		request.getSession().setAttribute("course", coursedao.showCouse());

		return "redirect:/courseRegister";
	}

}
