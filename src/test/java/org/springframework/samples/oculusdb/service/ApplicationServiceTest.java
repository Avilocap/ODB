
package org.springframework.samples.oculusdb.service;

import org.json.JSONException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.samples.oculusdb.administrator.PdfGeneratorUtil;
import org.springframework.samples.oculusdb.model.Application;
import org.springframework.samples.oculusdb.model.User;
import org.springframework.samples.oculusdb.services.ApplicationService;
import org.springframework.samples.oculusdb.services.UserService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.io.File;
import java.util.*;

@SpringBootTest
@Transactional
@SuppressWarnings("deprecation")
public class ApplicationServiceTest {

	@Autowired
	private ApplicationService applicationService;

	@Autowired
	private PdfGeneratorUtil pdfGenerator;

	@Autowired
	private UserService userService;

	@Test
	private void testCountWithInitialData() {
		Assert.isTrue(this.applicationService.applicationCount() >= 0);
	}

	@Test
	private void testFindAllWithInitialData() {
		Collection<Application> applications = new HashSet<>(
				(Collection<? extends Application>) this.applicationService.findAll());
		Assertions.assertNotNull(applications);
	}

	@Test
	private void getInfoOfOneApplicationRandomID() {
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
	private void getInfoOfOneApplicationNegativeWithRandomIDCase0() {
		Assertions.assertThrows(JSONException.class, () -> {
			this.applicationService.getInfoOfOneApplication("14718406166046");
		});
	}

	@Test
	private void getInfoOfOneApplicationNegativeWithRandomIDCase1() {
		Assertions.assertThrows(JSONException.class, () -> {
			this.applicationService.getInfoOfOneApplication("1471866046");
		});
	}

	@Test
	private void getInfoOfOneApplicationNegativeWithZeroID() {
		Assertions.assertThrows(JSONException.class, () -> {
			this.applicationService.getInfoOfOneApplication("0");
		});
	}

	@Test
	private void getInfoOfOneApplicationNegativeWithNegativeID() {
		Assertions.assertThrows(JSONException.class, () -> {
			this.applicationService.getInfoOfOneApplication("-34542356236546");
		});
	}

	@Test
	private void getInfoOfOneApplicationNullId() {
		Assertions.assertThrows(JSONException.class, () -> {
			this.applicationService.getInfoOfOneApplication(null);
		});

	}

	@Test
	private void shouldFindAppsById() {
		Application app = new Application();
		Optional<Application> ap2 = this.applicationService.findApplicationById(2);
		if (ap2.isPresent()) {
			app = ap2.get();
		}
		Assertions.assertNotNull(app);

	}

	@Test
	private void FindApplicationByRandomId() {
		Application app;
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
	private void findAllApplicationsInitialData() {
		Collection<Application> applications = new HashSet<>(
				(Collection<? extends Application>) this.applicationService.findAll());
		Assertions.assertTrue(applications.size() >= 1);
	}

	@Test
	private void findAllApplicationsHasErrors() {
		Collection<Application> applications = new HashSet<>(
				(Collection<? extends Application>) this.applicationService.findAll());
		Assertions.assertNotEquals(23457, applications.size());
	}

	@Test
	private void shouldDeleteApp() {
		List<Application> applications = new ArrayList<>(
				(Collection<? extends Application>) this.applicationService.findAll());

		Application app = new Application();
		Optional<Application> ap2 = this.applicationService.findApplicationById(applications.get(0).getId());
		if (ap2.isPresent()) {
			app = ap2.get();
		}

		this.applicationService.deleteApplication(app);
		Assertions.assertSame(this.applicationService.findApplicationById(applications.get(0).getId()),
				Optional.empty());

	}

	@Test
	private void shouldDeleteMultipleApps() {
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
	private void deleteApplicationRandomId() {
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

	@Test
	private void applicationToPDF_case0_OK() throws Exception {
		Optional<Application> app = this.applicationService.findApplicationById(100);
		Application application = app.get();

		Map<String, String> data = new HashMap<>();
		data.put("name", application.getName());
		data.put("description", application.getDescription());
		data.put("picture", application.getPicture());
		data.put("releaseDate", application.getReleaseDate().toString());
		data.put("price", application.getPrice().toString());
		data.put("website", application.getWebsite());
		data.put("company", application.getCompany());
		data.put("incomeEstimation", application.getIncomeEstimation().toString());
		data.put("salesEstimation", application.getSalesEstimation().toString());
		data.put("totalReviews", application.getTotalReviews().toString());

		File outputPDF = pdfGenerator.createPdf("applications/applicationOnPDF", data, application.getName());
		Assert.notNull(outputPDF);
	}

	@Test
	private void applicationToPDF_case1_OK() throws Exception {
		List<Application> apps = new ArrayList<>((List<? extends Application>) this.applicationService.findAll());
		Application appAux = apps.get(4);

		Application application = new Application();
		Optional<Application> ap = this.applicationService.findApplicationById(appAux.getId());
		if (ap.isPresent()) {
			application = ap.get();
		}

		Map<String, String> data = new HashMap<>();
		data.put("name", application.getName());
		data.put("description", application.getDescription());
		data.put("picture", application.getPicture());
		data.put("releaseDate", application.getReleaseDate().toString());
		data.put("price", application.getPrice().toString());
		data.put("website", application.getWebsite());
		data.put("company", application.getCompany());
		data.put("incomeEstimation", application.getIncomeEstimation().toString());
		data.put("salesEstimation", application.getSalesEstimation().toString());
		data.put("totalReviews", application.getTotalReviews().toString());

		File outputPDF = pdfGenerator.createPdf("applications/applicationOnPDF", data, application.getName());
		Assert.notNull(outputPDF);
	}

	@Test
	private void applicationToPDF_NotOK() {
		List<Application> apps = new ArrayList<>((List<? extends Application>) this.applicationService.findAll());
		Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
			Application application = apps.get(7652);
			Map<String, String> data = new HashMap<>();
			data.put("name", application.getName());
			data.put("description", application.getDescription());
			data.put("picture", application.getPicture());
			data.put("releaseDate", application.getReleaseDate().toString());
			data.put("price", application.getPrice().toString());
			data.put("website", application.getWebsite());
			data.put("company", application.getCompany());
			data.put("incomeEstimation", application.getIncomeEstimation().toString());
			data.put("salesEstimation", application.getSalesEstimation().toString());
			data.put("totalReviews", application.getTotalReviews().toString());

			File outputPDF = pdfGenerator.createPdf("applications/applicationOnPDF", data, application.getName());
			Assert.notNull(outputPDF);
		});
	}

	@Test
	private void addToFavourites_case0() {
		List<Application> apps = new ArrayList<>((List<? extends Application>) this.applicationService.findAll());
		Application appAux = apps.get(4);
		List<User> users = new ArrayList<>((List<? extends User>) this.userService.findAll());
		User userAux = users.get(2);
		int favorites = userAux.getFavorites().size();
		String currentPrincipalName = userAux.getUsername();
		Application app = new Application();
		User user = this.userService.userByUsername(currentPrincipalName);
		Optional<Application> ap = this.applicationService.findApplicationById(appAux.getId());
		if (ap.isPresent()) {
			app = ap.get();
		}
		user.getFavorites().add(app);
		userService.saveUser(user);
		Assertions.assertEquals(favorites + 1, user.getFavorites().size());
	}

	@Test
	private void addToFavourites_case1() {
		List<Application> apps = new ArrayList<>((List<? extends Application>) this.applicationService.findAll());
		Application appAux = apps.get(2);
		List<User> users = new ArrayList<>((List<? extends User>) this.userService.findAll());
		User userAux = users.get(1);
		int favorites = userAux.getFavorites().size();
		String currentPrincipalName = userAux.getUsername();
		Application app = new Application();
		User user = this.userService.userByUsername(currentPrincipalName);
		Optional<Application> ap = this.applicationService.findApplicationById(appAux.getId());
		if (ap.isPresent()) {
			app = ap.get();
		}
		user.getFavorites().add(app);
		userService.saveUser(user);
		Assertions.assertEquals(favorites + 1, user.getFavorites().size());
	}

	@Test
	private void addToFavourites_addingAnAlreadyAddedFavFromCase1() {
		List<Application> apps = new ArrayList<>((List<? extends Application>) this.applicationService.findAll());
		Application appAux = apps.get(2);
		List<User> users = new ArrayList<>((List<? extends User>) this.userService.findAll());
		User userAux = users.get(1);
		String currentPrincipalName = userAux.getUsername();
		Application app = new Application();
		User user = this.userService.userByUsername(currentPrincipalName);
		Optional<Application> ap = this.applicationService.findApplicationById(appAux.getId());
		if (ap.isPresent()) {
			app = ap.get();
		}
		user.getFavorites().add(app);
		userService.saveUser(user);
	}

	@Test
	private void addToFavourites_ofNotExistentUser() {
		List<Application> apps = new ArrayList<>((List<? extends Application>) this.applicationService.findAll());
		Application appAux = apps.get(2);
		List<User> users = new ArrayList<>((List<? extends User>) this.userService.findAll());
		Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
			User userAux = users.get(1324);
			String currentPrincipalName = userAux.getUsername();
			Application app = new Application();
			User user = this.userService.userByUsername(currentPrincipalName);
			Optional<Application> ap = this.applicationService.findApplicationById(appAux.getId());
			if (ap.isPresent()) {
				app = ap.get();
			}
			user.getFavorites().add(app);
			userService.saveUser(user);
		});
	}

	@Test
	private void addToFavourites_ofNotExistentApp() {
		List<User> users = new ArrayList<>((List<? extends User>) this.userService.findAll());
		Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
			List<Application> apps = new ArrayList<>((List<? extends Application>) this.applicationService.findAll());
			Application appAux = apps.get(23546476);
			User userAux = users.get(3);
			String currentPrincipalName = userAux.getUsername();
			Application app = new Application();
			User user = this.userService.userByUsername(currentPrincipalName);
			Optional<Application> ap = this.applicationService.findApplicationById(appAux.getId());
			if (ap.isPresent()) {
				app = ap.get();
			}
			user.getFavorites().add(app);
			userService.saveUser(user);
		});
	}

	@Test
	private void listingFavouriteApps() {
		User user = this.userService.userById(100);
		String currentPrincipalName = user.getUsername();
		List<Application> favorites = this.userService.userByUsername(currentPrincipalName).getFavorites();
		Assert.notNull(favorites);
	}

	@Test
	private void listingFavouriteAppsOfNoExistentUser() {
		List<User> users = new ArrayList<>((List<? extends User>) this.userService.findAll());
		Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
			User userAux = users.get(142344);
			String currentPrincipalName = userAux.getName();
			List<Application> favorites = this.userService.userByUsername(currentPrincipalName).getFavorites();
			Assert.notNull(favorites);
		});
	}

}
