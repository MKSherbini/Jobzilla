//package com.mksherbini.jobzilla.models.orm;
//
//import com.mksherbini.jobzilla.models.enums.SkillLevel;
//import com.mksherbini.jobzilla.models.orm.ids.SkillId;
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
//@IdClass(SkillId.class)
//public class Skill {
//    @ManyToOne
//    @Id
//    private Technology name;
//
//    @Id
//    private SkillLevel level = SkillLevel.NONE;
//
//    @ManyToMany(mappedBy = "requiredSkills")
//    private List<Job> jobs = new ArrayList<>();
//
//    @ManyToMany(mappedBy = "skills")
//    private List<User> skilled = new ArrayList<>();
//
//    public Skill(Technology name, SkillLevel level) {
//        this.name = name;
//        this.level = level;
//    }
//}
