
package org.springframework.samples.oculusdb.service;

import java.security.Provider.Service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.samples.oculusdb.controllers.ApplicationService;

@DataJpaTest(includeFilters = @ComponentScan.Filter(Service.class))
public class ApplicationServiceTest {

	@Autowired
	private ApplicationService applicationService;


	@Test
	public void testCountWithInitialData() {
		int count = this.applicationService.applicationCount();
		Assertions.assertEquals(count, 3);
	}

}
