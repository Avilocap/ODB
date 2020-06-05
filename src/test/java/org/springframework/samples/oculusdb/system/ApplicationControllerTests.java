/*
 * Copyright 2012-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.samples.oculusdb.system;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.samples.oculusdb.controllers.ApplicationController;
import org.springframework.samples.oculusdb.model.Application;
import org.springframework.samples.oculusdb.services.ApplicationService;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Test class for {@link ApplicationController}
 *
 * @author Miguel Ángel Antolín Bermúdez @mruwzum
 */

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Transactional
class ApplicationControllerTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ApplicationService applicationService;

	private static final int TEST_APPLICATION_ID = 102;

	private Application application1;

	@Test
	@WithMockUser("testuser")
	void listApps() throws Exception {
		mockMvc.perform(get("/applications/list")).andExpect(status().isOk());
	}

	@Test
	@WithMockUser("testuser")
	void listFavs() throws Exception {
		mockMvc.perform(get("/applications/favorites")).andExpect(status().isOk());
	}

	@Test
	@WithMockUser("testuser")
	void testInitFindForm() throws Exception {
		mockMvc.perform(get("/applications/appInfo/{appId}", 2)).andExpect(status().isOk());
	}

	@WithMockUser("testuser")
	@Test
	void testProcessFindFormNoAppsFound() throws Exception {
		mockMvc.perform(get("/applications").param("lastName", "Unknown Surname"))
				.andExpect(status().is4xxClientError());
	}

	@WithMockUser("testuser")
	@Test
	void testGetApplication() throws Exception {
		mockMvc.perform(get("/applications/loadGet")).andExpect(view().name("applications/getApplication"));
	}

	@WithMockUser("testuser")
	@Test
	void testProcessUpdateAppFormSuccess() throws Exception {
		mockMvc.perform(post("/applications/appInfo/edit", TEST_APPLICATION_ID).param("name", "dsadf")
				.param("description", "asdfsdfdsfasdfdsf").param("picture", "http://picos.com/pic.png")
				.param("company", "EA")).andExpect(status().is2xxSuccessful())
				.andExpect(view().name("applications/createOrUpdateApplicationForm"));
	}

	@WithMockUser("testuser")
	@Test
	void testProcessUpdateAppFormHasErrors() throws Exception {
		mockMvc.perform(post("/applications/appInfo/edit", TEST_APPLICATION_ID).param("name", "")
				.param("description", "sadfsdfdsf").param("picture", "3")).andExpect(status().is2xxSuccessful());
	}

	@Test
	@WithMockUser("testuser")
	void testPDFexport() throws Exception {
		mockMvc.perform(post("/applications/pdf/{appId}", TEST_APPLICATION_ID)).andExpect(status().is4xxClientError());
	}

	@Test
	@WithMockUser("testuser")
	void testInitDeleteFavorite() throws Exception {
		mockMvc.perform(get("/applications/favorites/delete").param("appId", String.valueOf(TEST_APPLICATION_ID)))
				.andExpect(status().isOk()).andExpect(view().name("applications/favorites"));
	}

	@Test
	@WithMockUser("testuser")
	void testDeleteFavoriteSuccess() throws Exception {
		mockMvc.perform(get("/applications/favorites/delete").param("appId", String.valueOf(TEST_APPLICATION_ID)))
				.andExpect(status().isOk()).andExpect(view().name("applications/favorites"));
	}

	@Test
	@WithMockUser("testuser")
	void testDeleteFavoriteHasErrors() throws Exception {
		mockMvc.perform(get("/applications/favorites/delete").param("appId", String.valueOf(TEST_APPLICATION_ID)))
				.andExpect(status().isOk())
				// .andExpect(model().attribute("application", hasProperty("name",
				// is("testuser"))))
				// .andExpect(model().attribute("application", hasProperty("company",
				// is("true"))))
				.andExpect(view().name("applications/favorites"));
	}

	@Test
	@WithMockUser("testuser")
	void testInitFavorites() throws Exception {
		mockMvc.perform(get("/applications/favorites")).andExpect(status().isOk())
				.andExpect(view().name("applications/favorites"));
	}

	@Test
	@WithMockUser("testuser")
	void testFavoritesSuccess() throws Exception {
		mockMvc.perform(get("/applications/favorites")).andExpect(status().isOk())
				.andExpect(model().attributeExists("favorites")).andExpect(view().name("applications/favorites"));
	}

	@Test
	@WithMockUser("testuser")
	void testFavoritesHasErrors() throws Exception {
		mockMvc.perform(get("/applications/favorites")).andExpect(status().isOk())
				.andExpect(model().attributeExists("favorites")).andExpect(view().name("applications/favorites"));
	}

	@Test
	@WithMockUser("testuser")
	void testInitShowApp() throws Exception {
		mockMvc.perform(get("/applications/appInfo/{appId}", TEST_APPLICATION_ID)).andExpect(status().isOk())
				.andExpect(view().name("applications/applicationsDetails"));

	}

	@Test
	@WithMockUser("testuser")
	void testInitShowApplications() throws Exception {
		mockMvc.perform(get("/applications/list")).andExpect(status().isOk())
				.andExpect(view().name("applications/listadoAplicaciones"));
	}

	@Test
	@WithMockUser("testuser")
	void testShowApplicationsSucces() throws Exception {
		mockMvc.perform(get("/applications/list")).andExpect(status().isOk())
				.andExpect(model().attributeExists("applications"))
				.andExpect(view().name("applications/listadoAplicaciones"));
	}

	@Test
	@WithMockUser("testuser")
	void testShowApplicationsHasErrors() throws Exception {
		mockMvc.perform(get("/applications/list")).andExpect(status().isOk())
				.andExpect(model().attributeExists("applications"))
				.andExpect(view().name("applications/listadoAplicaciones"));
	}

}
