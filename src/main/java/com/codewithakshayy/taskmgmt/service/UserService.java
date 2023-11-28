package com.codewithakshayy.taskmgmt.service;

import java.util.List;

import com.codewithakshayy.taskmgmt.document.User;

public interface UserService {

	public User saveNewUser(User user);

	public List<User> getAllUsers();

	public User getUserByUid(String uid);

	public User updateUser(String uid, User user);

}
