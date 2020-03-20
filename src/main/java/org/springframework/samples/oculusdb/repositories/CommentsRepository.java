package org.springframework.samples.oculusdb.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.samples.oculusdb.application.Comments;

public interface CommentsRepository extends CrudRepository<Comments, Integer> {

}
