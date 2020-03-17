
package org.springframework.samples.oculusdb.service;

import java.io.IOException;
import java.security.Provider.Service;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

@SpringBootTest
@Transactional
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
		// Checking the pool size of apps after updating them.
		List<Application> apps = new ArrayList<Application>(
				(Collection<? extends Application>) this.applicationService.findAll());
		int sizeBefore = apps.size();
		// Upgrade process
		this.applicationService.getInfoOfOneApplication("1471853306166046");
		// Checking the pool size of apps before updating them.
		List<Application> appsUpdated = new ArrayList<Application>(
				(Collection<? extends Application>) this.applicationService.findAll());
		int sizeAfter = appsUpdated.size();
		// Let's make sure that they're different.
		org.junit.Assert.assertNotEquals(sizeBefore, sizeAfter);
	}

	@Test
	void getInfoOfOneApplicationRandomID() throws IOException {
		// Checking the pool size of apps after not-updating them.
		List<Application> apps = new ArrayList<Application>(
				(Collection<? extends Application>) this.applicationService.findAll());
		int sizeBefore = apps.size();
		// Upgrade process
		Assertions.assertThrows(JSONException.class, () -> {
			this.applicationService.getInfoOfOneApplication("34542356236546");
		});
		// Checking the pool size of apps before not-updating them.
		List<Application> appsUpdated = new ArrayList<Application>(
				(Collection<? extends Application>) this.applicationService.findAll());
		int sizeAfter = appsUpdated.size();
		// Let's make sure that they're equals on this case.
		org.junit.Assert.assertEquals(sizeBefore, sizeAfter);
	}

	@Test
	void getInfoOfOneApplicationNegativeWithRandomID() throws IOException {
		Assertions.assertThrows(JSONException.class, () -> {
			this.applicationService.getInfoOfOneApplication("14718406166046");
		});
	}

	@Test
	void getInfoOfOneApplicationNegativeWithZeroID() throws IOException {
		Assertions.assertThrows(JSONException.class, () -> {
			this.applicationService.getInfoOfOneApplication("0");
		});
	}

	@Test
	void getInfoOfOneApplicationNullId() throws IOException {
		Assertions.assertThrows(JSONException.class, () -> {
			this.applicationService.getInfoOfOneApplication(null);
		});

	}

}
