package com.mksherbini.jobzilla.models.orm.ids;

import com.mksherbini.jobzilla.models.enums.SkillLevel;
import com.mksherbini.jobzilla.models.orm.Technology;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SkillId implements Serializable {
    private Technology name;
    private SkillLevel level = SkillLevel.NONE;
}
