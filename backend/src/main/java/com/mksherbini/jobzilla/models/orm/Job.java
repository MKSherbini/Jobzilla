package com.mksherbini.jobzilla.models.orm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Job {
    @Id
    private String id;

    private String company;
    private String description;
    private String requirements;

//    @Column(name = "tech_profile")
//    private TechProfile techProfile = TechProfile.FULLSTACK;
//
//    @ManyToMany
//    @Column(name = "required_skills")
//    private List<Skill> requiredSkills = new ArrayList<>();
}
