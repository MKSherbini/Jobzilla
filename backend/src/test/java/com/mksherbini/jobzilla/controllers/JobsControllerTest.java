package com.mksherbini.jobzilla.controllers;

import com.mksherbini.jobzilla.models.orm.Job;
import com.mksherbini.jobzilla.repos.JobsRepo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
class JobsControllerTest {
    @Autowired
    private WebTestClient webTestClient;

    @Autowired
    private JobsRepo jobsRepo;

    private static final String JOBS_URL = "/jobs";

    @BeforeEach
    void setUp() {
        jobsRepo.saveAll(List.of(
                new Job(null, "company", "descr", "req"),
                new Job("abc", "company2", "descr2", "req2")
        )).blockLast();
    }

    @AfterEach
    void tearDown() {
        jobsRepo.deleteAll().block();
    }

    @Test
    void findAll() {
        webTestClient
                .get()
                .uri(JOBS_URL)
                .exchange()
                .expectStatus()
                .is2xxSuccessful()
                .expectBodyList(Job.class)
                .hasSize(2);
    }

    @Test
    void getJobById() {
        var id = "abc";
        webTestClient
                .get()
                .uri(JOBS_URL + "/{id}", id)
                .exchange()
                .expectStatus()
                .is2xxSuccessful()
//                .expectBody(Job.class)
//                .consumeWith(exchangeResult -> {
//                    var job = exchangeResult.getResponseBody();
//                    assert job != null;
//                })
                .expectBody()
                .jsonPath("$.company").isEqualTo("company2");
    }

    @Test
    void getJobById_not_found() {
        var id = "abc1";
        webTestClient
                .get()
                .uri(JOBS_URL + "/{id}", id)
                .exchange()
                .expectStatus()
                .isNotFound();
    }

    @Test
    void addJob() {
        var job = new Job(null, "company3", "descr3", "req3");
        webTestClient
                .post()
                .uri(JOBS_URL)
                .bodyValue(job)
                .exchange()
                .expectStatus()
                .isCreated()
                .expectBody(Job.class)
                .consumeWith(exchangeResult -> {
                    var savedJob = exchangeResult.getResponseBody();
                    assert Objects.requireNonNull(savedJob).getId() != null;
                });
    }

    @Test
    void updateJob() {
        var id = "abc";
        var updatedJob = new Job(id, "company3", "descr3", "req3");

        webTestClient
                .put()
                .uri(JOBS_URL + "/{id}", id)
                .bodyValue(updatedJob)
                .exchange()
                .expectStatus()
                .is2xxSuccessful()
                .expectBody(Job.class)
                .consumeWith(exchangeResult -> {
                    var job = exchangeResult.getResponseBody();
                    assert job != null;
                    assertEquals("company3", job.getCompany());
                });
    }

    @Test
    void updateJob_not_found() {
        var id = "abc1";
        var updatedJob = new Job(id, "company3", "descr3", "req3");

        webTestClient
                .put()
                .uri(JOBS_URL + "/{id}", id)
                .bodyValue(updatedJob)
                .exchange()
                .expectStatus()
                .isNotFound();
    }

    @Test
    void deleteJobById() {
        var id = "abc";
        webTestClient
                .delete()
                .uri(JOBS_URL + "/{id}", id)
                .exchange()
                .expectStatus()
                .isNoContent();
    }
}
