package com.org.dao;

import com.org.dto.User;

public interface UserDao {

	void addAndUpdateUser(User user);
	User fetchUserByEmailAndPassword(String email, String password);
	User fetchUserById(int id);
}
