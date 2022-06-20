package com.mksherbini.jobzilla.services;

import com.mksherbini.jobzilla.adapters.JobMapper;
import com.mksherbini.jobzilla.models.dto.JobDto;
import com.mksherbini.jobzilla.models.orm.Job;
import com.mksherbini.jobzilla.repos.JobsRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class JobService {

    private final JobsRepo jobsRepo;
    private final JobMapper jobMapper;

    public Mono<JobDto> addJob(JobDto job) {
        return jobsRepo.save(jobMapper.JobDtoToOrm(job)).map(jobMapper::JobOrmToDto).log();
    }

    public Flux<JobDto> findAll() {
        return jobsRepo.findAll().map(jobMapper::JobOrmToDto).log();
    }

    public Mono<Void> deleteById(String id) {
        return jobsRepo.deleteById(id).log();
    }

    public Mono<JobDto> update(JobDto job, String id) {
        return jobsRepo.findById(id)
                .flatMap(job1 -> {
                    job1.setCompany(job.getCompany());
                    job1.setDescription(job.getDescription());
                    job1.setRequirements(job.getRequirements());
                    return jobsRepo.save(job1);
                }).map(jobMapper::JobOrmToDto).log();
    }

    public Mono<JobDto> getJobById(String id) {
        return jobsRepo.findById(id).map(jobMapper::JobOrmToDto).log();

    }
}
