package com.test.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// import com.test.dto.UserReq;
import com.test.dto.UserRes;
import com.test.repo.UserRepo;

@Service
public class UserDaoImpl implements UserDao {

	@Autowired
	UserRepo repo;

	@Override
	public void insertUser(UserRes res) {

		repo.save(res);
	}

	@Override
	public void updateUser(UserRes res) {

		repo.save(res);
	}

	@Override
	public void deleteUser(int i) {
		repo.deleteById(i);

	}

	@Override
	public List<UserRes> showUser() {

		return (List<UserRes>) repo.findAll();
	}

	@Override
	public List<UserRes> specificUser(UserRes res) {
		if (res.getId() != 0) {
			return repo.findByid(res.getId());
		}
		if (!res.getName().equals("")) {
			return repo.findByname(res.getName());
		}
		return repo.findByNameAndId(res.getId(), res.getName());

	}

	@Override
	public UserRes specificUser1(UserRes res) {

		return repo.findById(res.getId()).get();
	}

}
