package com.example.bb.user.service;

import java.util.List;

import com.example.bb.user.model.Users;

public interface IUserService {

	Users signup(Users user); 
	Users signIn(Users user);
	Users getUserDetail(Long id);
	List<Users> getUserList();
	Users updateUser(Long userId,Users user);
	void deleteUser(Long userId);
	
	void forgotPassword(String username);
	void validatePassword(Users user);
	void resetPassword(Users user);

}
