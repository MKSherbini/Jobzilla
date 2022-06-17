package com.mksherbini.jobzilla.controllers;

import com.mksherbini.jobzilla.models.dto.JobDto;
import com.mksherbini.jobzilla.models.orm.Job;
import com.mksherbini.jobzilla.services.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/jobs")
public class JobsController {

    private final JobService jobService;

    @GetMapping
    Flux<Job> findAll() {
        return jobService.findAll().log();
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<Job>> getJobById(@PathVariable String id) {
        return jobService.getJobById(id)
                .map(job -> ResponseEntity.ok()
                        .body(job))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()))
                .log();
    }

    // TODO: 17/06/2022 use dto here 
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Job> addJob(@RequestBody Job job) {
        return jobService.addJob(job).log();
    }

    @PutMapping("/{id}")
    public Mono<ResponseEntity<Job>> updateJob(@RequestBody JobDto job, @PathVariable String id) {
        var updatedJobMono = jobService.update(job, id).log();
        return updatedJobMono
                .map(job1 -> ResponseEntity.ok()
                        .body(job1))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteJobById(@PathVariable String id) {
        return jobService.deleteById(id).log();
    }
}
