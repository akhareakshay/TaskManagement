package com.codewithakshayy.taskmgmt.service.serviceimpl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codewithakshayy.taskmgmt.document.User;
import com.codewithakshayy.taskmgmt.exception.AlreadyExistsException;
import com.codewithakshayy.taskmgmt.repository.UserRepository;
import com.codewithakshayy.taskmgmt.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

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

}
