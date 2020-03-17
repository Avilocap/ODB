
package org.springframework.samples.oculusdb.service;

import java.security.Provider.Service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.samples.oculusdb.services.SponsorService;
import org.springframework.samples.oculusdb.sponsor.Sponsor;

@DataJpaTest(includeFilters = @ComponentScan.Filter(Service.class))
public class SponsorServiceTests {

	@Autowired
	private SponsorService sponsorService;


	@Test
	public void testCount() {
		int id = 0;
		Sponsor s = this.sponsorService.sponsorById(id);
		Sponsor s2 = this.sponsorService.sponsorById(id);
		Assertions.assertEquals(s, s2);
	}
}
