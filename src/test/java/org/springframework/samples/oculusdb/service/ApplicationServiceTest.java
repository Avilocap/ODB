
package org.springframework.samples.oculusdb.service;

import java.io.IOException;
import java.security.Provider.Service;
import java.util.Collection;
import java.util.HashSet;

import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import org.json.JSONException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.samples.oculusdb.OculusDBApplication;
import org.springframework.samples.oculusdb.controllers.ApplicationService;
import org.springframework.samples.oculusdb.model.Application;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

@SpringBootTest
public class ApplicationServiceTest {

	@Autowired
	private ApplicationService applicationService;

	@Test
	public void testCountWithInitialData() {
		Assert.notNull(this.applicationService.applicationCount());
	}

	@Test
	public void testFindAllWithInitialData() {
		Collection<Application> applications = new HashSet<Application>(
				(Collection<? extends Application>) this.applicationService.findAll());
		Assertions.assertNotNull(applications);
	}

	@Test
	void getInfoOfOneApplication() throws IOException {
		Assertions.assertThrows(DataIntegrityViolationException.class, () -> {
			this.applicationService.getInfoOfOneApplication("1471853306166046");
		});
	}

	@Test
	void getInfoOfOneApplicationNullId() throws IOException {
		Assertions.assertThrows(JSONException.class, () -> {
			this.applicationService.getInfoOfOneApplication(null);
		});

	}

}
