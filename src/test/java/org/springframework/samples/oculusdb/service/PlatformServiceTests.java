
package org.springframework.samples.oculusdb.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.samples.oculusdb.services.PlatformService;

@SpringBootTest
public class PlatformServiceTests {

	@Autowired
	private PlatformService platformService;

	@Test
	public void testCount() {
		int count = this.platformService.platformCount();
		Assertions.assertTrue(count > 0);
	}

}
