package com.mksherbini.jobzilla.models.orm;

import com.mksherbini.jobzilla.models.enums.TechProfile;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Job {
    @Id
    @org.springframework.data.annotation.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

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
