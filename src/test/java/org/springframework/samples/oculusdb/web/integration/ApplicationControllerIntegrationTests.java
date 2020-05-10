package org.springframework.samples.oculusdb.web.integration;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.samples.oculusdb.controllers.ApplicationController;
import org.springframework.samples.oculusdb.model.Application;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.MapBindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApplicationControllerIntegrationTests {

	private static final int TEST_APPLICATION_ID = 100;

	@Autowired
	private ApplicationController applicationController;

	@WithMockUser("testuser")
	@Test
	void testListAppsSuccess() throws Exception {
		ModelMap modelMap = new ModelMap();
		String lista = applicationController.listadoAplicaciones(modelMap);
		assertNotNull(modelMap.getAttribute("applications"));
		assertEquals(lista, "applications/listadoAplicaciones");
	}

	@WithMockUser("testuser")
	@Test
	void testListAppsHasErrors1() throws Exception {
		ModelMap modelMap = new ModelMap();
		String lista = applicationController.listadoAplicaciones(modelMap);
		modelMap.addAttribute("applicationss", null);
		assertNull(modelMap.getAttribute("applicationss"));
	}

	@WithMockUser("testuser")
	@Test
	void testListAppsHasErrors2() throws Exception {
		ModelMap modelMap = new ModelMap();
		String lista = applicationController.listadoAplicaciones(modelMap);
		assertNotEquals(lista, "applications/listadoAplicacionesss");
	}

	@WithMockUser("testuser")
	@Test
	void testShowAppSuccess() throws Exception {
		ModelAndView view = applicationController.showOwner2(TEST_APPLICATION_ID);
		assertNotNull(view.getModel().get("app"));
		assertEquals(view.getViewName(), "applications/applicationsDetails");
	}

	@WithMockUser("testuser")
	@Test
	void testShowAppHasErrors() throws Exception {
		ModelAndView view = applicationController.showOwner2(TEST_APPLICATION_ID);
		assertNotEquals(view.getViewName(), "applications/applicationsDetailss");
	}

	@Test
	void testInitUpdateFormSuccess() throws Exception {
		ModelMap model = new ModelMap();
		String view = applicationController.initUpdateForm(TEST_APPLICATION_ID, model);
		assertNotNull(model.getAttribute("app"));
		assertEquals(view, "applications/createOrUpdateApplicationForm");
	}

	@Test
	void testInitUpdateFormHasErrors() throws Exception {
		ModelMap model = new ModelMap();
		String view = applicationController.initUpdateForm(TEST_APPLICATION_ID, model);
		assertNotNull(model.getAttribute("app"));
		assertNotEquals(view, "applications/createOrUpdateApplicationFormm");
	}

	@Test
	void testProcessUpdateFormSuccess() throws Exception {
		Application application = new Application();
		application.setOculusId("200");
		application.setName("App1");
		BindingResult result = new MapBindingResult(Collections.emptyMap(), "");
		ModelMap model = new ModelMap();
		String vista = applicationController.processUpdateForm(application, result, model);
		assertEquals(vista, "applications/applicationsDetails");
	}

	@Test
	void testProcessUpdateHasErrors() throws Exception {
		Application application = new Application();
		application.setOculusId("200");
		application.setName("App1");
		ModelMap model = new ModelMap();
		model.addAttribute("app", null);
		BindingResult result = new MapBindingResult(Collections.emptyMap(), "");
		ObjectError error = new ObjectError("app", "This is a error");
		result.addError(error);
		String vista = applicationController.processUpdateForm(application, result, model);
		assertEquals(vista, "applications/createOrUpdateApplicationForm");
	}

	@Test
	void testDeleteAppSuccess() throws Exception {
		int app_ID = 200;
		String vista = applicationController.deleteApp(app_ID);
		assertEquals(vista, "applications/todoOk");
	}

	@Test
	void testDeleteAppHasErrors() throws Exception {
		int app_ID = 200;
		String vista = applicationController.deleteApp(app_ID);
		assertNotEquals(vista, "applications/todoOkk");
	}

	@WithMockUser("testuser")
	@Test
	void testAddToFavoritesSuccess() throws Exception {
		ModelMap model = new ModelMap();
		applicationController.deleteFavorite(TEST_APPLICATION_ID, model);
		ModelMap model2 = new ModelMap();
		String vista = applicationController.addToFavorites(TEST_APPLICATION_ID, model2);
		assertNotNull(model.getAttribute("favorites"));
		assertEquals(vista, "applications/favorites");
	}

	@WithMockUser("testuser")
	@Test
	void testAddToFavoritesHasErrors() throws Exception {
		ModelMap model = new ModelMap();
		applicationController.deleteFavorite(TEST_APPLICATION_ID, model);
		ModelMap model2 = new ModelMap();
		String vista = applicationController.addToFavorites(TEST_APPLICATION_ID, model2);
		assertNotEquals(vista, "applications/favoritess");
	}

	@WithMockUser("testuser")
	@Test
	void testDeleteFavoriteSuccess() throws Exception {
		ModelMap model = new ModelMap();
		String vista = applicationController.deleteFavorite(TEST_APPLICATION_ID, model);
		assertEquals(vista, "applications/favorites");
	}

	@WithMockUser("testuser")
	@Test
	void testDeleteFavoriteHasErrors() throws Exception {
		ModelMap model = new ModelMap();
		String vista = applicationController.deleteFavorite(TEST_APPLICATION_ID, model);
		assertNotEquals(vista, "applications/favoritess");
	}

	@WithMockUser("testuser")
	@Test
	void testFavoritesSuccess() throws Exception {
		ModelMap modelMap = new ModelMap();
		String vista = applicationController.favorites(modelMap);
		assertNotNull(modelMap.getAttribute("favorites"));
		assertEquals(vista, "applications/favorites");
	}

	@WithMockUser("testuser")
	@Test
	void testFavoritesHasErrors() throws Exception {
		ModelMap modelMap = new ModelMap();
		String vista = applicationController.favorites(modelMap);
		assertNotEquals(vista, "applications/favoritess");
	}

}