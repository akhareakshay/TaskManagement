package com.codewithakshayy.taskmgmt.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.codewithakshayy.taskmgmt.document.Task;

public interface TaskRepository extends MongoRepository<Task, String> {

	public Task findByTaskId(String taskId);

}
