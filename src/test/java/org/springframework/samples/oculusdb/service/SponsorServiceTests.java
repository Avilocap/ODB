
package org.springframework.samples.oculusdb.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.samples.oculusdb.services.SponsorService;
import org.springframework.samples.oculusdb.sponsor.Sponsor;

@SpringBootTest
public class SponsorServiceTests {

	@Autowired
	private SponsorService sponsorService;


	@Test
	public void testId() {
		int id = 0;
		Sponsor s = this.sponsorService.sponsorById(id);
		Sponsor s2 = this.sponsorService.sponsorById(id);
		Assertions.assertEquals(s, s2);
	}
}
