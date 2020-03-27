package org.springframework.samples.oculusdb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.samples.oculusdb.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {

	@Query("select c from User c where c.username = ?1")
	User findByUsername(String username);

}