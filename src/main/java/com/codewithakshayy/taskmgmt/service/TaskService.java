package com.codewithakshayy.taskmgmt.service;

import java.util.List;

import com.codewithakshayy.taskmgmt.document.Task;

public interface TaskService {

	public Task saveNewTask(Task task);

	public List<Task> getAllTasks();

	public Task getTaskById(String taskId);

	public Task updateTask(String taskId, Task task);

}
