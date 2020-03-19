package org.springframework.samples.oculusdb.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.samples.oculusdb.sponsor.Sponsor;

public interface SponsorRepository extends CrudRepository<Sponsor, Integer>{

}
