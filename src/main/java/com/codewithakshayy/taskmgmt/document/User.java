package com.codewithakshayy.taskmgmt.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

/*
 * @Document uses in mongodb for tables, whereas collection is nothing but the table name
 * @Data used to generate getter,setters using lombok
 * @Id use to generate id
 * 
*/
@Document
@Data
public class User {

	@Id
	private String id;
	private String username;
	private String email;
	private String password;

}
