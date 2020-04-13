
package org.springframework.samples.oculusdb.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.samples.oculusdb.services.SponsorService;
import org.springframework.samples.oculusdb.sponsor.Sponsor;
import org.springframework.samples.oculusdb.system.WelcomeController;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class SponsorServiceTests {

	@Autowired
	private SponsorService sponsorService;

	@Test
	public void testId() {
		int id = 1;
		Sponsor s = this.sponsorService.sponsorById(id);
		Sponsor s2 = this.sponsorService.sponsorById(id);
		Assertions.assertEquals(s.getName(), s2.getName());
	}

}
