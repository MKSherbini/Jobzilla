package com.mksherbini.jobzilla.services;

import com.mksherbini.jobzilla.models.dto.JobDto;
import com.mksherbini.jobzilla.models.orm.Job;
import com.mksherbini.jobzilla.repos.JobsJpaRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@RequiredArgsConstructor
public class JobService {
    private final JobsJpaRepo jobsJpaRepo;

    @PostConstruct
    public void addJob() {
        jobsJpaRepo.save(new Job()).subscribe();
    }

    public void listJobs() {

    }

}
