package org.springframework.samples.oculusdb.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.samples.oculusdb.sponsor.Sponsorship;

public interface SponsorShipRepository extends CrudRepository<Sponsorship, Integer> {

}
