package com.mksherbini.jobzilla.controllers;

import com.mksherbini.jobzilla.models.orm.Job;
import com.mksherbini.jobzilla.services.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequiredArgsConstructor
@RequestMapping("/jobs")
public class JobsController {

    private final JobService jobService;

    @GetMapping
    Flux<Job> findAll() {
        return jobService.findAll().log();
    }
}
