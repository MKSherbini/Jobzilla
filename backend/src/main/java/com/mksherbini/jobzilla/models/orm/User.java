//package com.mksherbini.jobzilla.models.orm;
//
//import com.mksherbini.jobzilla.models.enums.TechProfile;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import javax.persistence.*;
//import java.util.ArrayList;
//import java.util.List;
//
//@Entity
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//public class User {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Integer id;
//
//    @Column(nullable = false)
//    private String name;
//
//    @Column(name = "tech_profile")
//    private TechProfile techProfile = TechProfile.FULLSTACK;
//
//    @ManyToMany
//    private List<Skill> skills = new ArrayList<>();
//}
