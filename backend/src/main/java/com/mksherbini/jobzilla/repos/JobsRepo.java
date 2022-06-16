package com.mksherbini.jobzilla.repos;

import com.mksherbini.jobzilla.models.orm.Job;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

//@RepositoryRestResource(exported = false)
public interface JobsRepo extends ReactiveMongoRepository<Job, Integer> {
}
