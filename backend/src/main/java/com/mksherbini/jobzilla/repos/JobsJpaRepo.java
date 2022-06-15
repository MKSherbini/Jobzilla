package com.mksherbini.jobzilla.repos;

import com.mksherbini.jobzilla.models.orm.Job;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

//@RepositoryRestResource(exported = false)
@Repository
public interface JobsJpaRepo extends ReactiveCrudRepository<Job, Integer> {
}
