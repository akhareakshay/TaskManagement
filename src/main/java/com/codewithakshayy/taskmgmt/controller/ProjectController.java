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

import com.codewithakshayy.taskmgmt.document.Project;
import com.codewithakshayy.taskmgmt.service.ProjectService;

@RestController
@RequestMapping("/project")
public class ProjectController {

	@Autowired
	private ProjectService projectService;

	@PostMapping(value = "/save", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> saveProject(@RequestBody Project project) {
		Project savedProject = projectService.saveNewProject(project);
		return new ResponseEntity<>(savedProject, HttpStatus.OK);
	}

	@GetMapping(value = "/get", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> getProjects() {
		List<Project> allProjects = projectService.getAllProjects();
		return new ResponseEntity<>(allProjects, HttpStatus.OK);
	}

	@GetMapping(value = "/get/{projectId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> getProject(@PathVariable String projectId) {
		Project project = projectService.getProject(projectId);
		return new ResponseEntity<>(project, HttpStatus.OK);
	}

	@PostMapping(value = "/get/{projectId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> updateProject(@PathVariable String projectId, @RequestBody Project project) {
		Project updatedProject = projectService.updateProject(projectId, project);
		return new ResponseEntity<>(updatedProject, HttpStatus.OK);
	}

}
