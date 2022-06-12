package com.mksherbini.jobzilla.models.dto;

import com.mksherbini.jobzilla.models.enums.TechProfile;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobDto {
    private String company;
    private String description;
    private String requirements;
    private TechProfile techProfile = TechProfile.FULLSTACK;
    private List<SkillDto> requiredSkills = new ArrayList<>();
}
