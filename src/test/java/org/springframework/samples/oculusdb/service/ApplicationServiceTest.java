
package org.springframework.samples.oculusdb.service;

import org.json.JSONException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.samples.oculusdb.services.ApplicationService;
import org.springframework.samples.oculusdb.model.Application;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import javax.swing.text.html.Option;
import java.io.IOException;
import java.util.*;

@SpringBootTest
@Transactional
@SuppressWarnings("deprecation")
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

		this.applicationService.getInfoOfOneApplication("1320373124698683");
		// Checking the pool size of apps before updating them.
		List<Application> appsUpdated = new ArrayList<>(
				(Collection<? extends Application>) this.applicationService.findAll());
		// Let's make sure that they're different.
		int sizeAfter = appsUpdated.size();
		org.junit.Assert.assertNotEquals(sizeBefore, sizeAfter);

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

	@Test
	void shouldFindAppsById() {
		Application app = new Application();
		Optional<Application> ap2 = this.applicationService.findApplicationById(2);
		if (ap2.isPresent()) {
			app = ap2.get();
		}
		Assertions.assertNotNull(app);

	}

	@Test
	void FindApplicationByRandomId() {
		Application app = new Application();
		Optional<Application> ap2 = this.applicationService.findApplicationById(273);
		if (ap2.isPresent()) {
			app = ap2.get();
		}
		else {
			app = null;
		}
		org.junit.Assert.assertNull(app);
	}

	@Test
	void findAllApplicationsInitialData() {
		Collection<Application> applications = new HashSet<>(
				(Collection<? extends Application>) this.applicationService.findAll());
		Assertions.assertTrue(applications.size() >= 1);
	}

	@Test
	void findAllApplicationsHasErrors() {
		Collection<Application> applications = new HashSet<>(
				(Collection<? extends Application>) this.applicationService.findAll());
		Assertions.assertNotEquals(23457, applications.size());
	}

	@Test
	void shouldDeleteApp() {
		Collection<Application> applications = new HashSet<>(
				(Collection<? extends Application>) this.applicationService.findAll());

		Application app = new Application();
		Optional<Application> ap2 = this.applicationService.findApplicationById(113);
		if (ap2.isPresent()) {
			app = ap2.get();
		}

		this.applicationService.deleteApplication(app);
		Assertions.assertSame(this.applicationService.findApplicationById(113), Optional.empty());

	}

	@Test
	void shouldDeleteMultipleApps() {
		List<Application> apps = new ArrayList<>((List<? extends Application>) this.applicationService.findAll());

		Application app0 = apps.get(0);
		int idOfApp0 = app0.getId();
		Application app1 = apps.get(1);
		int idOfApp1 = app1.getId();

		this.applicationService.deleteApplication(app0);
		this.applicationService.deleteApplication(app1);

		Assertions.assertSame(this.applicationService.findApplicationById(idOfApp0), Optional.empty());
		Assertions.assertSame(this.applicationService.findApplicationById(idOfApp1), Optional.empty());

	}

	@Test
	void deleteApplicationRandomId() {
		Collection<Application> applications = new HashSet<>(
				(Collection<? extends Application>) this.applicationService.findAll());

		Application app = new Application();
		Optional<Application> ap2 = this.applicationService.findApplicationById(273);
		if (ap2.isPresent()) {
			app = ap2.get();
		}

		this.applicationService.deleteApplication(app);
		Collection<Application> applications2 = new HashSet<>(
				(Collection<? extends Application>) this.applicationService.findAll());

		Assertions.assertEquals(applications.size(), applications2.size());
	}

}
