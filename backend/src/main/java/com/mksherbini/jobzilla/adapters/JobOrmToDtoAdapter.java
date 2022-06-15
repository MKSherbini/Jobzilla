//package com.mksherbini.jobzilla.adapters;
//
//import com.mksherbini.jobzilla.models.dto.JobDto;
//import com.mksherbini.jobzilla.models.orm.Job;
//import lombok.RequiredArgsConstructor;
//import org.modelmapper.ModelMapper;
//import org.springframework.stereotype.Component;
//
//@Component
//@RequiredArgsConstructor
//public class JobOrmToDtoAdapter implements GenericAdapter<Job, JobDto> {
//    private final ModelMapper modelMapper;
//    private final SkillOrmToDtoAdapter technologyAdapter;
//
//    @Override
//    public JobDto adapt(Job orm) {
//        final var dto = modelMapper.map(orm, JobDto.class);
//        dto.setRequiredSkills(technologyAdapter.adapt(orm.getRequiredSkills()));
//        return dto;
//    }
//}
