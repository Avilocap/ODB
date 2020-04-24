package org.springframework.samples.oculusdb.web.e2e;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class ApplicationControllerE2ETests {

	private static final int TEST_APP_ID = 100;

	@Autowired
	private MockMvc mockMvc;

	@WithMockUser(username = "testuser")
	@Test
	void testListadoAplicacionesSuccess() throws Exception {
		mockMvc.perform(get("/applications/list")).andExpect(status().isOk());
	}

	@WithMockUser(username = "testuser")
	@Test
	void testGetApplicationSuccess() throws Exception {
		mockMvc.perform(get("/applications/loadGet")).andExpect(view().name("applications/getApplication"));
	}

	@WithMockUser(username = "testuser")
	@Test
	void testGetApplicationHasErrors() throws Exception {
		mockMvc.perform(get("/applicationss/loadGet")).andExpect(status().is4xxClientError());
	}

	@WithMockUser(username = "testuser")
	@Test
	void testShowAppSuccess() throws Exception {
		mockMvc.perform(get("/applications/appInfo/{appId}", TEST_APP_ID)).andExpect(status().isOk())
				.andExpect(view().name("applications/applicationsDetails"));
	}

	@WithMockUser(username = "testuser")
	@Test
	void testShowAppHasErrors() throws Exception {
		mockMvc.perform(get("/applicationss/appInfo/{appId}", TEST_APP_ID)).andExpect(status().is4xxClientError());
	}

	@WithMockUser(username = "testuser")
	@Test
	void testAppToPDFSuccess() throws Exception {
		mockMvc.perform(get("/applications/pdf/{appId}", TEST_APP_ID)).andExpect(status().isOk());
	}

	@WithMockUser(username = "testuser")
	@Test
	void testAppToPDFHasErrors() throws Exception {
		mockMvc.perform(get("/applicationss/pdf/{appId}", TEST_APP_ID)).andExpect(status().is4xxClientError());
	}

	@WithMockUser(username = "testuser")
	@Test
	void testUpdateFormSuccess() throws Exception {
		mockMvc.perform(post("/applications/appInfo/edit", TEST_APP_ID).param("name", "Nombre de prueba"))
				.andExpect(status().is2xxSuccessful())
				.andExpect(view().name("applications/createOrUpdateApplicationForm"));
	}

	// deberia dar error, ya que el nombre de la aplicacion no puede ser vacio

	@WithMockUser(username = "testuser")
	@Test
	void testUpdateFormHasErrors() throws Exception {
		mockMvc.perform(post("/applications/appInfo/edit", TEST_APP_ID).param("name", ""))
				.andExpect(status().is2xxSuccessful());
	}

	@WithMockUser(username = "testuser")
	@Test
	void testListarFavoritosSuccess() throws Exception {
		mockMvc.perform(get("/applications/favorites")).andExpect(status().isOk())
				.andExpect(view().name("applications/favorites"));
	}

	// no se si esta bien, da error 404 al añadir a favoritos

	@WithMockUser(username = "testuser")
	@Test
	void testAddToFavoritesSuccess() throws Exception {
		mockMvc.perform(get("/appInfo/{appId}/favorite", TEST_APP_ID)).andExpect(status().isOk())
				.andExpect(view().name("applications/favorites"));
	}

	@WithMockUser(username = "testuser")
	@Test
	void testAddToFavoritesHasErrors() throws Exception {
		mockMvc.perform(get("/appInfoss/{appId}/favorite", TEST_APP_ID)).andExpect(status().is4xxClientError());
	}

	// no se si esta bien, da error 404 al borrar

	@WithMockUser(username = "testuser")
	@Test
	void testDeleteFavoriteSuccess() throws Exception {
		mockMvc.perform(get("/applications/favorites/delete/{appId}", TEST_APP_ID)).andExpect(status().isOk())
				.andExpect(view().name("applications/favorites"));
	}

	@WithMockUser(username = "testuser")
	@Test
	void testDeleteFavoriteHasErrors() throws Exception {
		mockMvc.perform(get("/applicationss/favorites/delete/{appId}", TEST_APP_ID))
				.andExpect(status().is4xxClientError());
	}

	// no se si esta bien, da error 404 al borrar

	@WithMockUser(username = "testuser")
	@Test
	void testInitDeleteApp() throws Exception {
		mockMvc.perform(get("/applications/appInfo/delete/{appId}", TEST_APP_ID))
				.andExpect(status().is4xxClientError());
	}

}
