package org.springframework.samples.oculusdb.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.samples.oculusdb.application.Reviews;

public interface ReviewRepository extends CrudRepository<Reviews, Integer> {

}
