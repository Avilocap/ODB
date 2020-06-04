
package org.springframework.samples.oculusdb.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.oculusdb.repositories.SponsorShipRepository;
import org.springframework.samples.oculusdb.sponsor.Sponsorship;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class SponsorShipService {

	@Autowired
	private SponsorShipRepository sponsorShipRepository;

	@Transactional
	public void saveSponsorship(Sponsorship sponsorship) {
		this.sponsorShipRepository.save(sponsorship);
	}

	@Transactional
	public int sponsorShipCount() {
		return (int) this.sponsorShipRepository.count();
	}

}
