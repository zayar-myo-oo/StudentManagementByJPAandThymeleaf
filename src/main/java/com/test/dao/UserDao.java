package com.test.dao;

import java.util.List;

// import com.test.dto.UserReq;
import com.test.dto.UserRes;

public interface UserDao {

	void insertUser(UserRes res);

	void updateUser(UserRes res);

	void deleteUser(int i);

	List<UserRes> showUser();

	List<UserRes> specificUser(UserRes res);

	UserRes specificUser1(UserRes res);

}
