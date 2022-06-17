package com.mksherbini.jobzilla.services;

import com.mksherbini.jobzilla.models.dto.JobDto;
import com.mksherbini.jobzilla.models.orm.Job;
import com.mksherbini.jobzilla.repos.JobsRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class JobService {

    private final JobsRepo jobsRepo;

    public void addJob(JobDto jobDto) {

    }

    public Flux<Job> findAll() {
        return jobsRepo.findAll().log();
    }

}
