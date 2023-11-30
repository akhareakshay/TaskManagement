package com.codewithakshayy.taskmgmt.document;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document
@Data
public class Project {

	@Id
	private String projectId;
	private String name;
	private String descirption;
	private List<Task> tasks;
	private LocalDateTime startDate;
	private LocalDateTime endDate;

}
