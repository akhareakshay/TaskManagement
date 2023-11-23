package com.codewithakshayy.taskmgmt.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document
@Data
public class User {

	@Id
	private String id;
	private String username;
	private String email;
	private String password;

}
