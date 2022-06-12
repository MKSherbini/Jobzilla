package com.mksherbini.jobzilla.adapters;

import com.mksherbini.jobzilla.models.dto.SkillDto;
import com.mksherbini.jobzilla.models.orm.Skill;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SkillOrmToDtoAdapter implements GenericAdapter<Skill, SkillDto> {
    private final ModelMapper modelMapper;

    @Override
    public SkillDto adapt(Skill orm) {
        return modelMapper.map(orm, SkillDto.class);
    }
}
