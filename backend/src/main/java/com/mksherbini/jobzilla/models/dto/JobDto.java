package com.mksherbini.jobzilla.models.dto;

import com.mksherbini.jobzilla.models.enums.TechProfile;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobDto {
    @NotBlank(message = "company name must be present")
    private String company;
    @NotBlank(message = "job description must be present")
    private String description;
    @NotBlank(message = "job requirements must be present")
    private String requirements;
//    private TechProfile techProfile = TechProfile.FULLSTACK;
//    private List<@NotBlank SkillDto> requiredSkills = new ArrayList<>();
}
