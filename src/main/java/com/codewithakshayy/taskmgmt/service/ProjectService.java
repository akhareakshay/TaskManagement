package com.codewithakshayy.taskmgmt.service;

import java.util.List;

import com.codewithakshayy.taskmgmt.document.Project;

public interface ProjectService {

	public Project saveNewProject(Project project);

	public List<Project> getAllProjects();

	public Project getProject(String projectId);

	public Project updateProject(String projectId, Project project);

}
