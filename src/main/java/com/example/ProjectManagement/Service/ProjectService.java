package com.example.ProjectManagement.Service;

import com.example.ProjectManagement.Entity.Project;
import com.example.ProjectManagement.Exception.ResourceNotFoundException;

import java.util.List;

public interface ProjectService {

    Project CreateProject(Project project);

    List<Project> getAllProject() throws ResourceNotFoundException;

    Project getProjectById(Long projectId) throws ResourceNotFoundException;

    Project updateProject(Long projectId, Project projectDetails) throws ResourceNotFoundException;

    void deleteProject(Long projectId) throws ResourceNotFoundException;

}
