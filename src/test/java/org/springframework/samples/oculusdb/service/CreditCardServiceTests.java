
package org.springframework.samples.oculusdb.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.samples.oculusdb.services.CreditCardService;

@SpringBootTest
public class CreditCardServiceTests {

	@Autowired
	private CreditCardService creditCardService;


	@Test
	public void testCount() {
		int count = this.creditCardService.creditCardCount();
		Assertions.assertEquals(count, 0);
	}

}
