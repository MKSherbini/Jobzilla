package com.mksherbini.jobzilla.services;

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

    public Mono<Job> addJob(Job job) {
        return jobsRepo.save(job).log();
    }

    public Flux<Job> findAll() {
        return jobsRepo.findAll().log();
    }

    public Mono<Void> deleteById(String id) {
        return jobsRepo.deleteById(id).log();
    }

    public Mono<Job> update(JobDto job, String id) {
        return jobsRepo.findById(id)
                .flatMap(job1 -> {
                    job1.setCompany(job.getCompany());
                    job1.setDescription(job.getDescription());
                    job1.setRequirements(job.getRequirements());
                    return jobsRepo.save(job1);
                }).log();
    }

    public Mono<Job> getJobById(String id) {
        return jobsRepo.findById(id).log();

    }
}
