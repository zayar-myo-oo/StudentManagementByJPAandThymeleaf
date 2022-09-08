package com.test.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// import com.test.dto.UserReq;
import com.test.dto.UserRes;
import com.test.repo.UserRepo;

@Service
public class LoginLogoutDaoImpl implements LoginLogoutDao {

	@Autowired
	UserRepo repo;

	@Override
	public UserRes login(UserRes req) {

		return repo.findByidAndpassword(req.getId(), req.getPassword());
	}

}
