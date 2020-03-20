
package org.springframework.samples.oculusdb.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.samples.oculusdb.services.SponsorShipService;

@SpringBootTest
public class SponsorShipServiceTests {

	@Autowired
	private SponsorShipService sponsorShipService;

	@Test
	public void testCount() {
		int count = this.sponsorShipService.sponsorShipCount();
		Assertions.assertEquals(count, 0);
	}

}
