
package org.springframework.samples.oculusdb.service;

import java.security.Provider.Service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.samples.oculusdb.services.CreditCardService;

@DataJpaTest(includeFilters = @ComponentScan.Filter(Service.class))
public class CreditCardServiceTests {

	@Autowired
	private CreditCardService creditCardService;


	@Test
	public void testCount() {
		int count = this.creditCardService.creditCardCount();
		Assertions.assertEquals(count, 1);
	}

}
