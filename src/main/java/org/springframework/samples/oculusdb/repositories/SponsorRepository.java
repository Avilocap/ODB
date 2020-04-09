package org.springframework.samples.oculusdb.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.samples.oculusdb.model.User;
import org.springframework.samples.oculusdb.sponsor.Sponsor;

public interface SponsorRepository extends CrudRepository<Sponsor, Integer> {

	@Query("select c from Sponsor c where c.username = ?1")
	Sponsor findByUsername(String username);

}
