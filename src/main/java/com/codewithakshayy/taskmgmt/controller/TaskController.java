package com.codewithakshayy.taskmgmt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codewithakshayy.taskmgmt.document.Task;
import com.codewithakshayy.taskmgmt.service.TaskService;

@RestController
@RequestMapping("/task")
public class TaskController {

	@Autowired
	private TaskService taskService;

	@PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> saveTask(@RequestBody Task task) {
		Task savedTask = taskService.saveNewTask(task);
		return new ResponseEntity<>(savedTask, HttpStatus.OK);
	}

	@GetMapping(value = "/get", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> getAllTasks() {
		List<Task> allTasks = taskService.getAllTasks();
		return new ResponseEntity<>(allTasks, HttpStatus.OK);
	}

	@GetMapping(value = "/get/{taskId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> getTaskByTaskId(@PathVariable String taskId) {
		Task task = taskService.getTaskById(taskId);
		return new ResponseEntity<>(task, HttpStatus.OK);
	}

	@PostMapping(value = "/update/{taskId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> updateTaskByTaskId(@PathVariable String taskId, @RequestBody Task task) {
		Task updatedTask = taskService.updateTask(taskId, task);
		return new ResponseEntity<>(updatedTask, HttpStatus.OK);
	}

}
