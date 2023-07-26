package com.example.ProjectManagement.Entity;

import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Project")
public class Project {

    @Transient
    public static final String SEQUENCE_NAME = "project_sequence";

    @Id
    private long id;

    private String projectName;

    private String clientName;

    private LocalDate startDate;

    private LocalDate endDate;

    private String duration;

    private List<String> skills;

    private String location;
}
