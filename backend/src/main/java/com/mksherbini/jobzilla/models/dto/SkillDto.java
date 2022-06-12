package com.mksherbini.jobzilla.models.dto;

import com.mksherbini.jobzilla.models.enums.SkillLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SkillDto {
    private String name;
    private SkillLevel level = SkillLevel.NONE;
}
