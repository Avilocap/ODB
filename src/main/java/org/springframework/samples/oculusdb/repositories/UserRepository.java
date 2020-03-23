
package org.springframework.samples.oculusdb.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.samples.oculusdb.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

	@Query("select u from User u where u.userAccount.nick = ?1")
	Optional<User> findByNick(String nick);

}
