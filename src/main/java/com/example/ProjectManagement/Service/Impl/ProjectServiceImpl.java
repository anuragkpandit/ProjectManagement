package com.example.ProjectManagement.Service.Impl;

import com.example.ProjectManagement.Entity.Project;
import com.example.ProjectManagement.Exception.ResourceNotFoundException;
import com.example.ProjectManagement.Repository.ProjectRepository;
import com.example.ProjectManagement.Service.ProjectService;
import com.example.ProjectManagement.Service.SequenceGeneratorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    @Override
    public Project CreateProject(Project project) {
        project.setId(sequenceGeneratorService.generateSequence(Project.SEQUENCE_NAME));
        log.info("Employee data saved successfully");
        return projectRepository.save(project);
    }

    @Override
    public List<Project> getAllProject() throws ResourceNotFoundException {
        return projectRepository.findAll();
    }

    @Override
    public Project getProjectById(Long projectId) throws ResourceNotFoundException {
        return projectRepository.findById(projectId).orElseThrow(() -> new ResourceNotFoundException("id is not present" + projectId));
    }

    @Override
    public Project updateProject(Long projectId, Project projectDetails) throws ResourceNotFoundException {

        Project projectCheck = projectRepository.findById(projectId).orElseThrow(() -> new ResourceNotFoundException("id is not present" + projectId));

        projectCheck.setProjectName(projectDetails.getProjectName());
        projectCheck.setLocation(projectDetails.getLocation());
        projectCheck.setSkills(projectDetails.getSkills());
        projectCheck.setStartDate(projectDetails.getStartDate());
        projectCheck.setDuration(projectDetails.getDuration());
        projectCheck.setEndDate(projectDetails.getEndDate());
        projectCheck.setClientName(projectDetails.getClientName());
        return projectRepository.save(projectCheck);
    }

    @Override
    public void deleteProject(Long projectId) throws ResourceNotFoundException {
        Project project = projectRepository.findById(projectId).orElseThrow(() -> new ResourceNotFoundException("id is not present" + projectId));
        projectRepository.delete(project);
    }
}
