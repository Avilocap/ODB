
package org.springframework.samples.oculusdb.service;

import java.security.Provider.Service;
import java.util.Collection;
import java.util.HashSet;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.samples.oculusdb.OculusDBApplication;
import org.springframework.samples.oculusdb.controllers.ApplicationService;
import org.springframework.samples.oculusdb.model.Application;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
public class ApplicationServiceTest {

	@Autowired
	private ApplicationService applicationService;

	@Test
	public void testCountWithInitialData() {
		int count = this.applicationService.applicationCount();
		Assertions.assertEquals(count, 3);
	}


	@Test
	public void testFindAllWithInitialData() {
		Collection<Application> applications = new HashSet<Application>((Collection<? extends Application>) this.applicationService.findAll());
		Assertions.assertNotNull(applications);
	}

}
