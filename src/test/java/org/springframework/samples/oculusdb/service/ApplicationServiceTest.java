
package org.springframework.samples.oculusdb.service;

import org.json.JSONException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.samples.oculusdb.controllers.ApplicationService;
import org.springframework.samples.oculusdb.model.Application;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.io.IOException;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

@SpringBootTest
public class ApplicationServiceTest {

	@Autowired
	private ApplicationService applicationService;

	@Test
	public void testCountWithInitialData() {
		Assert.isTrue(this.applicationService.applicationCount() >= 0);
	}

	@Test
	public void testFindAllWithInitialData() {
		Collection<Application> applications = new HashSet<>(
				(Collection<? extends Application>) this.applicationService.findAll());
		Assertions.assertNotNull(applications);
	}

	@Test
	void getInfoOfOneApplicationCase0() throws IOException, JSONException {
		// Checking the pool size of apps after updating them.
		List<Application> apps = new ArrayList<>((Collection<? extends Application>) this.applicationService.findAll());
		int sizeBefore = apps.size();
		// Upgrade process
		Assertions.assertThrows(DataIntegrityViolationException.class, () -> {
			this.applicationService.getInfoOfOneApplication("2385436581584047");
			// Checking the pool size of apps before updating them.
			List<Application> appsUpdated = new ArrayList<>(
					(Collection<? extends Application>) this.applicationService.findAll());
			// Let's make sure that they're different.
			int sizeAfter = appsUpdated.size();
			org.junit.Assert.assertNotEquals(sizeBefore, sizeAfter);
		});

	}

	@Test
	void getInfoOfOneApplicationIfExists() throws IOException, JSONException {
		// Checking the pool size of apps after updating them.
		List<Application> apps = new ArrayList<>((Collection<? extends Application>) this.applicationService.findAll());
		int sizeBefore = apps.size();
		Assertions.assertThrows(JSONException.class, () -> {
			// Upgrade process
			this.applicationService.getInfoOfOneApplication("2104963472963790");
			// Checking the pool size of apps before updating them.
			this.applicationService.getInfoOfOneApplication("1471853306160646");
			List<Application> appsUpdated = new ArrayList<>(
					(Collection<? extends Application>) this.applicationService.findAll());
			int sizeAfter = appsUpdated.size();
			org.junit.Assert.assertNotEquals(sizeBefore, sizeAfter);
		});

	}

	@Test
	void getInfoOfOneApplicationRandomID() {
		// Checking the pool size of apps after not-updating them.
		List<Application> apps = new ArrayList<>((Collection<? extends Application>) this.applicationService.findAll());
		int sizeBefore = apps.size();
		// Upgrade process
		Assertions.assertThrows(JSONException.class, () -> {
			this.applicationService.getInfoOfOneApplication("34542356236546");
		});
		// Checking the pool size of apps before not-updating them.
		List<Application> appsUpdated = new ArrayList<>(
				(Collection<? extends Application>) this.applicationService.findAll());
		int sizeAfter = appsUpdated.size();
		// Let's make sure that they're equals on this case.
		org.junit.Assert.assertEquals(sizeBefore, sizeAfter);
	}

	@Test
	void getInfoOfOneApplicationNegativeWithRandomIDCase0() {
		Assertions.assertThrows(JSONException.class, () -> {
			this.applicationService.getInfoOfOneApplication("14718406166046");
		});
	}

	@Test
	void getInfoOfOneApplicationNegativeWithRandomIDCase1() {
		Assertions.assertThrows(JSONException.class, () -> {
			this.applicationService.getInfoOfOneApplication("1471866046");
		});
	}

	@Test
	void getInfoOfOneApplicationNegativeWithZeroID() {
		Assertions.assertThrows(JSONException.class, () -> {
			this.applicationService.getInfoOfOneApplication("0");
		});
	}

	@Test
	void getInfoOfOneApplicationNullId() {
		Assertions.assertThrows(JSONException.class, () -> {
			this.applicationService.getInfoOfOneApplication(null);
		});

	}

}
