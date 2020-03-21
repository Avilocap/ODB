
package org.springframework.samples.oculusdb.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.samples.oculusdb.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {

	Optional<User> findByUsername(String username);
}
