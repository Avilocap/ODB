
package org.springframework.samples.oculusdb.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.samples.oculusdb.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

	Optional<User> findByNick(String nick);

}
