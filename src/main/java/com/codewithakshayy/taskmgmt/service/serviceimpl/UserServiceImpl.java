package com.codewithakshayy.taskmgmt.service.serviceimpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codewithakshayy.taskmgmt.document.User;
import com.codewithakshayy.taskmgmt.exception.AlreadyExistsException;
import com.codewithakshayy.taskmgmt.exception.NotFoundException;
import com.codewithakshayy.taskmgmt.exception.NullPointerException;
import com.codewithakshayy.taskmgmt.repository.UserRepository;
import com.codewithakshayy.taskmgmt.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User saveNewUser(User user) {
		User newUser;
		User existingUser = null;

		if (user.getUid() != null)
			existingUser = userRepository.findByUid(user.getUid());

		if (existingUser == null) {
			user.setRegistrationDateTime(new Date());
			newUser = userRepository.save(user);
		} else
			throw new AlreadyExistsException("User with id : " + user.getUid() + " is Already Exists");

		return newUser;
	}

	@Override
	public List<User> getAllUsers() {
		List<User> allUsers = userRepository.findAll();
		return allUsers;
	}

	@Override
	public User getUserByUid(String uid) {
		User foundUser = null;
		if (uid.equalsIgnoreCase("null"))
			throw new NullPointerException("uid is not passed / passed null");

		if (!uid.isEmpty())
			foundUser = userRepository.findByUid(uid);

		if (foundUser == null)
			throw new NotFoundException("User with uid : " + uid + ", not found");
		return foundUser;
	}

	@Override
	public User updateUser(String uid, User user) {
		User updatedUser = null;
		User foundUser = getUserByUid(uid);
		if (foundUser != null) {
			user.setUid(uid);
			user.setEmail(user.getEmail());
			user.setPassword(user.getPassword());
			user.setUsername(user.getUsername());

			updatedUser = userRepository.save(user);
		}
		return updatedUser;
	}

}
