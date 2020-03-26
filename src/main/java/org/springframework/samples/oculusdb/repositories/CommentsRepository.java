package org.springframework.samples.oculusdb.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.samples.oculusdb.application.Comments;

import java.util.Collection;

public interface CommentsRepository extends CrudRepository<Comments, Integer> {

    @Query("select c from Comments c where c.application.id = ?1")
    Iterable<Comments> findAllByApplicationId(int applicationId);

}
