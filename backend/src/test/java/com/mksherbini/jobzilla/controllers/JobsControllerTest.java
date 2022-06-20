package com.mksherbini.jobzilla.controllers;

import com.mksherbini.jobzilla.models.dto.JobDto;
import com.mksherbini.jobzilla.models.orm.Job;
import com.mksherbini.jobzilla.repos.JobsRepo;
import com.mksherbini.jobzilla.services.JobService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@WebFluxTest(controllers = JobsController.class)
@AutoConfigureWebTestClient
class JobsControllerTest {

    @MockBean
    private JobsRepo jobsRep;

    @MockBean
    private JobService jobService;

    @Autowired
    private WebTestClient webTestClient;

    private static final String JOBS_URL = "/jobs";

    @Test
    void findAll() {
        var jobs = List.of(
                new JobDto("company", "descr", "req"),
                new JobDto("company2", "descr2", "req2")
        );

        when(jobService.findAll()).thenReturn(Flux.fromIterable(jobs));

        webTestClient
                .get()
                .uri(JOBS_URL)
                .exchange()
                .expectStatus()
                .is2xxSuccessful()
                .expectBodyList(JobDto.class)
                .hasSize(2);
    }

    @Test
    void getJobById() {
        var id = "abc";
        var job = new JobDto("company", "descr", "req");

        when(jobService.getJobById(id)).thenReturn(Mono.just(job));

        webTestClient
                .get()
                .uri(JOBS_URL + "/{id}", id)
                .exchange()
                .expectStatus()
                .is2xxSuccessful()
                .expectBody(JobDto.class)
                .consumeWith(exchangeResult -> {
                    var received = exchangeResult.getResponseBody();
                    assertThat(received)
                            .isNotNull()
                            .hasNoNullFieldsOrProperties()
                            .isEqualTo(job);
                });
    }

    @Test
    void addJob() {
        var job = new JobDto("company3", "descr3", "req3");
        when(jobService.addJob(isA(JobDto.class))).thenReturn(Mono.just(job));

        webTestClient
                .post()
                .uri(JOBS_URL)
                .bodyValue(job)
                .exchange()
                .expectStatus()
                .isCreated()
                .expectBody(JobDto.class)
                .consumeWith(exchangeResult -> {
                    var savedJob = exchangeResult.getResponseBody();
                    assertThat(savedJob)
                            .isNotNull()
                            .hasNoNullFieldsOrProperties()
                            .isEqualTo(job);
                });
    }

    @Test
    void addJob_validation() {

        var job = new JobDto("", "", "");

        when(jobService.addJob(isA(JobDto.class))).thenReturn(Mono.just(job));


        webTestClient
                .post()
                .uri(JOBS_URL)
                .bodyValue(job)
                .exchange()
                .expectStatus()
                .isBadRequest()
                .expectBody(String.class)
                .consumeWith(result -> {
                    var error = result.getResponseBody();
                    assertNotNull(error);
                    String expectedErrorMessage = "company name must be present, job description must be present, job requirements must be present";
                    assertEquals(expectedErrorMessage, error);
                });
    }

    @Test
    void updateJob() {
        var id = "abc1";
        var job = new JobDto("company3", "descr3", "req3");

        when(jobService.update(any(JobDto.class), anyString())).thenReturn(Mono.just(job));

        webTestClient
                .put()
                .uri(JOBS_URL + "/{id}", id)
                .bodyValue(job)
                .exchange()
                .expectStatus()
                .is2xxSuccessful()
                .expectBody(JobDto.class)
                .consumeWith(exchangeResult -> {
                    var updatedJob = exchangeResult.getResponseBody();
                    assertThat(updatedJob)
                            .isNotNull()
                            .hasNoNullFieldsOrProperties()
                            .isEqualTo(job);
                });
    }

    @Test
    void updateJob_not_found() {
        var id = "abc1";
        var job = new JobDto("company3", "descr3", "req3");

        when(jobService.update(any(JobDto.class), anyString())).thenReturn(Mono.empty());

        webTestClient
                .put()
                .uri(JOBS_URL + "/{id}", id)
                .bodyValue(job)
                .exchange()
                .expectStatus()
                .isNotFound();
    }

    @Test
    void deleteJobById() {
        var id = "abc";

        when(jobService.deleteById(id)).thenReturn(Mono.empty());

        webTestClient
                .delete()
                .uri(JOBS_URL + "/{id}", id)
                .exchange()
                .expectStatus()
                .isNoContent();
    }
}
