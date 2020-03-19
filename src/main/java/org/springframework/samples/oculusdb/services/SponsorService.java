
package org.springframework.samples.oculusdb.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.oculusdb.repositories.SponsorRepository;
import org.springframework.samples.oculusdb.sponsor.Sponsor;
import org.springframework.stereotype.Service;

@Service
public class SponsorService {

	@Autowired
	private SponsorRepository sponsorRepository;


	@Transactional
	public Sponsor sponsorById(final int id) {
		return this.sponsorRepository.findById(id).orElse(null);
	}

}
