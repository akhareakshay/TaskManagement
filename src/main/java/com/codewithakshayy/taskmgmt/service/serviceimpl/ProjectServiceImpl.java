package com.codewithakshayy.taskmgmt.service.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codewithakshayy.taskmgmt.document.Project;
import com.codewithakshayy.taskmgmt.exception.AlreadyExistsException;
import com.codewithakshayy.taskmgmt.exception.NoRecordsException;
import com.codewithakshayy.taskmgmt.exception.NotFoundException;
import com.codewithakshayy.taskmgmt.repository.ProjectRepository;
import com.codewithakshayy.taskmgmt.service.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private ProjectRepository projectRepository;

	@Override
	public Project saveNewProject(Project project) {
		Project newProject;
		Project existingProject = null;

		if (project.getProjectId() != null) {
			existingProject = projectRepository.findByProjectId(project.getProjectId());
		}

		if (existingProject == null)
			newProject = projectRepository.save(project);
		else
			throw new AlreadyExistsException(
					"Project with projectId : '" + project.getProjectId() + "' is Already Exists");

		return newProject;
	}

	@Override
	public List<Project> getAllProjects() {
		List<Project> allProjects = projectRepository.findAll();

		if (allProjects.size() < 1)
			throw new NoRecordsException("No Records Available Yet");

		return allProjects;
	}

	@Override
	public Project getProject(String projectId) {
		Project project = projectRepository.findByProjectId(projectId);

		if (project == null)
			throw new NotFoundException("Project with projectId : '" + projectId + "' not found");

		return project;
	}

	@Override
	public Project updateProject(String projectId, Project project) {
		Project updatedProject = null;
		Project foundProject = getProject(projectId);

		if (foundProject != null) {
			project.setProjectId(projectId);
			project.setName(project.getName());
			project.setDescirption(project.getDescirption());
			project.setTasks(project.getTasks());
			project.setStartDate(project.getStartDate());
			project.setEndDate(project.getEndDate());
			updatedProject = projectRepository.save(project);
		}
		return updatedProject;
	}

}
