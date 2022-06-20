package com.mksherbini.jobzilla.adapters;

import com.mksherbini.jobzilla.models.dto.JobDto;
import com.mksherbini.jobzilla.models.orm.Job;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public abstract class JobMapper {

    @InheritInverseConfiguration
    public abstract JobDto JobOrmToDto(Job job);

    public abstract List<JobDto> JobListOrmToDto(List<Job> job);

    @Mapping(target = "id", ignore = true)
    public abstract Job JobDtoToOrm(JobDto job);

    public abstract List<Job> JobListDtoToOrm(List<JobDto> job);
}
