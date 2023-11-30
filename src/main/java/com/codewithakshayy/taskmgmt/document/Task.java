package com.codewithakshayy.taskmgmt.document;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document
@Data
public class Task {

	public enum TaskStatus {
		TODO, INPROGRESS, COMPLETED
	}

	@Id
	private String taskId;
	private String title;
	private String description;
	private String assignor;
	private String assignee;
	private LocalDateTime dueDate;
	private TaskStatus status;
	@CreatedDate
	private LocalDateTime createdAt;
	@LastModifiedDate
	private LocalDateTime updatedAt;

}
