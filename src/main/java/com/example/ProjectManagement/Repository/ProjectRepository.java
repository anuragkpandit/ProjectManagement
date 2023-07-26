package com.example.ProjectManagement.Repository;

import com.example.ProjectManagement.Entity.Project;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends MongoRepository<Project, Long> {
}
