package com.mksherbini.jobzilla.repos;

import com.mksherbini.jobzilla.models.orm.Job;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataMongoTest
//        (excludeAutoConfiguration = EmbeddedMongoAutoConfiguration.class)
//@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
//@TestPropertySource(properties = "spring.mongodb.embedded.version=3.5.5")
//@ActiveProfiles("test")
class JobsRepoTest {

    @Autowired
    private JobsRepo jobsRepo;

    @BeforeEach
    void setUp() {
        jobsRepo.saveAll(List.of(
                new Job(null, "company", "descr", "req"),
                new Job(null, "company2", "descr2", "req2")
        )).blockLast();
    }

    @AfterEach
    void tearDown() {
        jobsRepo.deleteAll().block();
    }

    @Test
    void findAll() {

        final Flux<Job> jobFlux = jobsRepo.findAll().log();

        StepVerifier.create(jobFlux)
                .expectNextCount(2)
                .verifyComplete();
    }
}
