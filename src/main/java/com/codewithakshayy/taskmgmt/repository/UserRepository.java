package com.codewithakshayy.taskmgmt.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.codewithakshayy.taskmgmt.document.User;

public interface UserRepository extends MongoRepository<User, String> {

	public User findByUid(String uid);

}
