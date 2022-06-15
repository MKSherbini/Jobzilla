package com.mksherbini.jobzilla.adapters;

import com.mksherbini.jobzilla.models.dto.JobDto;
import com.mksherbini.jobzilla.models.orm.Job;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JobDtoToOrmAdapter implements GenericAdapter<JobDto, Job> {
    private final ModelMapper modelMapper;
    private final SkillDtoToOrmAdapter technologyAdapter;

    @Override
    public Job adapt(JobDto o) {
        final var dto = modelMapper.map(o, Job.class);
//        dto.setRequiredSkills(technologyAdapter.adapt(o.getRequiredSkills()));
        return dto;
    }
}
