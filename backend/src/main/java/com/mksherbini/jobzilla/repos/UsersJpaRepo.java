package com.mksherbini.jobzilla.repos;

import com.mksherbini.jobzilla.models.orm.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(exported = false)
public interface UsersJpaRepo extends JpaRepository<User, Integer> {
}
