package org.springframework.samples.oculusdb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.samples.oculusdb.model.User;
import org.springframework.samples.oculusdb.sponsor.Sponsorship;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {

	@Query("select c from User c where c.username = ?1")
	User findByUsername(String username);

	@Query("select c.sponsorships from User c where c = ?1")
	List<Sponsorship> sponoshorShipOfUser(User user);

}