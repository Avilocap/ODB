
package org.springframework.samples.oculusdb.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.oculusdb.repositories.SponsorShipRepository;
import org.springframework.stereotype.Service;

@Service
public class SponsorShipService {

	@Autowired
	private SponsorShipRepository sponsorShipRepository;


	@Transactional
	public int sponsorShipCount() {
		return (int) this.sponsorShipRepository.count();
	}
}
