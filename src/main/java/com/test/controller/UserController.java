package com.test.controller;

// import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
// import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.test.bean.User;
import com.test.dao.LoginLogoutDao;
import com.test.dao.UserDao;
// import com.test.dto.UserReq;
import com.test.dto.UserRes;

//@MappedTypes(User.class)
@Controller
public class UserController {

	@Autowired
	LoginLogoutDao logindao;

	@Autowired
	UserDao userdao;

	@GetMapping("/URegister")
	public ModelAndView register(HttpServletRequest request) {

		request.getSession().setAttribute("user", userdao.showUser());
		return new ModelAndView("USR001", "user", new User());
	}

	@PostMapping("/UserReigster")
	public String proessingRegister(@ModelAttribute("user") User user, HttpServletRequest request) {

		if (user.getName().equals("") || user.getEmail().equals("") || user.getConfirm().equals("") ||
				user.getPassword().equals("") || user.getRole().equals("")) {
			request.setAttribute("error", "fill all the requirement");
			return "USR001";

		}

		if (!user.getPassword().equals(user.getConfirm())) {
			request.setAttribute("error", "doesnt match with password!!");
			return "USR001";
		}

		UserRes req = new UserRes();

		req.setName(user.getName());
		req.setEmail(user.getEmail());
		req.setPassword(user.getPassword());
		req.setRole(user.getRole());

		userdao.insertUser(req);

		request.getSession().setAttribute("user", userdao.showUser());

		return "redirect:/UserShow";
	}

	@GetMapping("/UserShow")
	public ModelAndView searchUser(HttpServletRequest request) {

		if (request.getSession().getAttribute("user") == null) {
			return new ModelAndView("redirect:/");
		} else {
			request.getSession().setAttribute("user", userdao.showUser());
			// userdao.showUser().forEach(m -> System.out.println(m));
			return new ModelAndView("USR003", "user", new User());
		}

	}

	@PostMapping("/processingUsearch")
	public String processingSearch(@ModelAttribute("user") User user, HttpServletRequest request) {
		UserRes req = new UserRes();
		if (user.getId().equals("")) {
			req.setId(0);
		} else {
			req.setId(Integer.valueOf(user.getId()));
		}
		req.setName(user.getName());

		if (userdao.specificUser(req) == null) {
			return "redirect:/UserShow?notfound='User not found!!'";
		}
		request.getSession().setAttribute("user", userdao.specificUser(req));
		userdao.specificUser(req).forEach(m -> System.out.println(m));
		return "USR003";
	}

	@GetMapping("/updateUser/{id}")
	public ModelAndView updateUser(@PathVariable("id") Integer id, HttpServletRequest request) {

		UserRes req = new UserRes();
		req.setId(Integer.valueOf(id));
		// request.getSession().setAttribute("user", userdao.specificUser(req));
		// return new ModelAndView("USR002","user", new User());
		return new ModelAndView("USR002", "user", userdao.specificUser1(req));
	}

	@PostMapping("/UserUpdate")
	public String processingUpdate(@ModelAttribute("user") User user, HttpServletRequest request) {

		if (user.getName().equals("") || user.getEmail().equals("") || user.getConfirm().equals("") ||
				user.getPassword().equals("") || user.getRole().equals("")) {
			request.setAttribute("error", "fill all the requirement");
			return "USR002";

		}

		if (!user.getPassword().equals(user.getConfirm())) {
			request.setAttribute("error", "doesnt match with password!!");
			return "USR002";
		}

		UserRes req = new UserRes();
		req.setId(Integer.valueOf(user.getId()));
		req.setName(user.getName());
		req.setEmail(user.getEmail());
		req.setPassword(user.getPassword());
		req.setRole(user.getRole());

		userdao.updateUser(req);

		UserRes res = (UserRes) request.getSession().getAttribute("login");

		if (req.getId().equals(res.getId())) {
			request.getSession().setAttribute("login", logindao.login(req));
		}
		request.getSession().setAttribute("user", userdao.showUser());

		return "redirect:/UserShow";
	}

	@GetMapping("/deleteUser/{id}")
	public String deleteUser(@PathVariable("id") Integer id, HttpServletRequest request) {
		UserRes res = (UserRes) request.getSession().getAttribute("login");
		UserRes req1 = new UserRes();
		req1.setId(Integer.valueOf(id));
		if (res.getId().equals(id)) {
			request.getSession().setAttribute("user", userdao.showUser());
			return "redirect:/UserShow?notfoun='u cannot delete'";
		}
		userdao.deleteUser(id);
		request.getSession().setAttribute("user", userdao.showUser());

		return "redirect:/UserShow";
	}

}
