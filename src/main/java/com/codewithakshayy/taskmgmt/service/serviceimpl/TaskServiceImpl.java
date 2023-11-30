package com.codewithakshayy.taskmgmt.service.serviceimpl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codewithakshayy.taskmgmt.document.Task;
import com.codewithakshayy.taskmgmt.exception.AlreadyExistsException;
import com.codewithakshayy.taskmgmt.exception.NoRecordsException;
import com.codewithakshayy.taskmgmt.exception.NotFoundException;
import com.codewithakshayy.taskmgmt.repository.TaskRepository;
import com.codewithakshayy.taskmgmt.service.TaskService;

@Service
public class TaskServiceImpl implements TaskService {

	@Autowired
	private TaskRepository taskRepository;

	@Override
	public Task saveNewTask(Task task) {
		Task newTask;
		Task existingTask = null;

		if (task.getTaskId() != null)
			existingTask = taskRepository.findByTaskId(task.getTaskId());

		if (existingTask == null) {
			task.setCreatedAt(LocalDateTime.now());
			newTask = taskRepository.save(task);
		} else
			throw new AlreadyExistsException("Task with taskId : '" + task.getTaskId() + "' is Already Exists");

		return newTask;
	}

	@Override
	public List<Task> getAllTasks() {
		List<Task> allTasks = taskRepository.findAll();
		if (allTasks.size() < 1)
			throw new NoRecordsException("No Records Available Yet");
		return allTasks;
	}

	@Override
	public Task getTaskById(String taskId) {
		Task task = taskRepository.findByTaskId(taskId);
		if (task == null)
			throw new NotFoundException("Task with taskId : '" + taskId + "' not found");
		return task;
	}

	@Override
	public Task updateTask(String taskId, Task task) {
		Task updatedTask = null;
		Task foundTask = getTaskById(taskId);
		if (foundTask != null) {
			task.setTaskId(taskId);
			task.setDescription(task.getDescription());
			task.setTitle(task.getTitle());
			task.setAssignor(task.getAssignor());
			task.setAssignee(task.getAssignee());
			task.setDueDate(task.getDueDate());
			task.setCreatedAt(foundTask.getCreatedAt());
			task.setUpdatedAt(LocalDateTime.now());
			updatedTask = taskRepository.save(task);
		}

		return updatedTask;
	}

}
