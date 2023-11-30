package com.codewithakshayy.taskmgmt.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.codewithakshayy.taskmgmt.document.Project;

public interface ProjectRepository extends MongoRepository<Project, String> {
	
	public Project findByProjectId(String projectId);

}
