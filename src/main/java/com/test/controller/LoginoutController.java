package com.test.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
// import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.beans.factory.annotation.Qualifier;
// import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
// import org.springframework.web.servlet.view.RedirectView;

// import com.test.bean.Student;
import com.test.bean.User;
import com.test.dao.CourseDao;
import com.test.dao.LoginLogoutDao;
import com.test.dao.StudentDao;
import com.test.dao.UserDao;
// import com.test.dto.CourseRes;
// import com.test.dto.StudentRes;
// import com.test.dto.UserReq;
import com.test.dto.UserRes;
// import com.test.repo.CourseRepo;

@Controller
public class LoginoutController {

	@Autowired
	LoginLogoutDao logindao;

	@Autowired
	StudentDao studentdao;

	@Autowired
	CourseDao coursedao;

	@Autowired
	UserDao userdao;

	@GetMapping("/")
	public ModelAndView welcome() {
		return new ModelAndView("LGN001", "user", new User());
	}

	@PostMapping("/Login")
	public String login(@ModelAttribute("user") User user, HttpServletRequest request) {
		UserRes req = new UserRes();
		req.setId(Integer.valueOf(user.getId()));
		req.setPassword(user.getPassword());

		if (logindao.login(req) == null) {
			return "redirect:/?error='not found!!'";

		}

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();

		if (coursedao.couresMaxid() != 0) {
			int i = coursedao.couresMaxid();
			i += 1;

			request.getSession().setAttribute("cid", i);
		}

		if (studentdao.studentMaxID() != 0) {
			int i = studentdao.studentMaxID();
			i += 1;
			System.out.println("student id  " + i);
			request.getSession().setAttribute("stuno", i);
		}

		request.getSession().setAttribute("course", coursedao.showCouse());
		request.getSession().setAttribute("login", logindao.login(req));
		request.getSession().setAttribute("date", dtf.format(now));
		request.getSession().setAttribute("user", userdao.showUser());
		// request.getSession().setAttribute("user",session.getMapper(Userdao.class).showUser());
		request.getSession().setAttribute("student", studentdao.showStudent());

		return "MNU001";
	}

	@GetMapping("/Logout")
	public String logout(HttpServletRequest request) {
		request.getSession(false);
		request.getSession().invalidate();
		return "redirect:/";
	}

}
