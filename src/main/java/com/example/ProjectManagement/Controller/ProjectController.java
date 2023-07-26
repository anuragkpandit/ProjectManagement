package com.example.ProjectManagement.Controller;

import com.example.ProjectManagement.Entity.Project;
import com.example.ProjectManagement.Exception.ResourceNotFoundException;
import com.example.ProjectManagement.Service.ProjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("api/")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    //Add
    @PostMapping("/project")
    public Project createProject(@RequestBody Project project) throws IOException {

        return projectService.CreateProject(project);
    }

    @GetMapping("/projects")
    public List<Project> getAllProject() throws ResourceNotFoundException{
        return projectService.getAllProject();
    }

    @GetMapping("/project/{id}")
    public ResponseEntity<Project> getProjectById(@PathVariable (value = "id") Long projectId) throws ResourceNotFoundException {
      return ResponseEntity.ok(projectService.getProjectById(projectId));
    }

    @PutMapping("/project/{id}")
    public Project updateProject(@PathVariable (value = "id") Long projectId,
                                 @RequestBody Project project) throws ResourceNotFoundException{
      return projectService.updateProject(projectId, project);
    }

    @DeleteMapping("/project/{id}")
    public Map<String, Boolean> deleteProject(@PathVariable (value = "id") Long projectId) throws ResourceNotFoundException{
        projectService.deleteProject(projectId);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
