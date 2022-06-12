package com.mksherbini.jobzilla.services;

import com.mksherbini.jobzilla.models.dto.JobDto;
import com.mksherbini.jobzilla.repos.JobsJpaRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JobService {
    private final JobsJpaRepo jobsJpaRepo;

    public void addJob(JobDto jobDto) {

    }

    public void listJobs() {

    }

}
