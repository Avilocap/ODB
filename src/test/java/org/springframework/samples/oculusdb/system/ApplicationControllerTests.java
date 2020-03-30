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

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.samples.oculusdb.controllers.ApplicationController;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.mockito.BDDMockito.given;

import org.springframework.samples.oculusdb.services.ApplicationService;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.lang.annotation.Inherited;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Test class for {@link ApplicationController}
 *
 * @author Miguel Ángel Antolín Bermúdez @mruwzum
 */

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
class ApplicationControllerTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ApplicationService applicationService;

	private static final int TEST_APPLICATION_ID = 8;

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
	void favApp() throws Exception {
		mockMvc.perform(post("/applications/appInfo/{appId}/favorite", 9)).andExpect(status().isOk());
	}

	@Test
	@WithMockUser("testuser")
	void testInitFindForm() throws Exception {
		mockMvc.perform(post("/applications/appInfo/{appId}").param("appId", "814885695293688"))
				.andExpect(status().is2xxSuccessful());
	}

	// @Test
	// void testProcessFindFormSuccess() throws Exception {
	// given(this.application.findByLastName("")).willReturn(Lists.newArrayList(george,
	// new User()));
	// mockMvc.perform(get("/applications")).andExpect(status().isOk()).andExpect(view().name("applications/applicationsList"));
	// }
	//
	// @Test
	// void testProcessFindFormByLastName() throws Exception {
	// given(this.applications.findByLastName(george.getLastName())).willReturn(Lists.newArrayList(george));
	// mockMvc.perform(get("/applications").param("lastName",
	// "Franklin")).andExpect(status().is3xxRedirection())
	// .andExpect(view().name("redirect:/applications/" + TEST_OWNER_ID));
	// }
	@WithMockUser("testuser")
	@Test
	void testProcessFindFormNoAppsFound() throws Exception {
		mockMvc.perform(get("/applications").param("lastName", "Unknown Surname")).andExpect(status().isOk())
				.andExpect(model().attributeHasFieldErrors("application", "lastName"))
				.andExpect(model().attributeHasFieldErrorCode("application", "lastName", "notFound"))
				.andExpect(view().name("applications/createOrUpdateOwnerForm"));
	}

	@WithMockUser("testuser")
	@Test
	void testInitUpdateAppForm() throws Exception {
		mockMvc.perform(post("/applications/appInfo/edit").param("appId", String.valueOf(TEST_APPLICATION_ID)))
				.andExpect(status().isOk()).andExpect(model().attributeExists("app"))
				.andExpect(model().attribute("app", hasProperty("name", is(""))))
				.andExpect(model().attribute("app", hasProperty("description", is(""))))
				.andExpect(view().name("applications/createOrUpdateOwnerForm"));
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
				.param("description", "sadfsdfdsf").param("picture", "3")).andExpect(status().is4xxClientError());
	}

	// @Test
	// void testShowOwner() throws Exception {
	// mockMvc.perform(get("/applications/{applicationId}",
	// TEST_OWNER_ID)).andExpect(status().isOk())
	// .andExpect(model().attribute("application", hasProperty("lastName",
	// is("Franklin"))))
	// .andExpect(model().attribute("application", hasProperty("firstName",
	// is("George"))))
	// .andExpect(model().attribute("application", hasProperty("address", is("110 W.
	// Liberty St."))))
	// .andExpect(model().attribute("application", hasProperty("city", is("Madison"))))
	// .andExpect(model().attribute("application", hasProperty("telephone",
	// is("6085551023"))))
	// .andExpect(model().attribute("application", hasProperty("pets", not(empty()))))
	// .andExpect(model().attribute("application", hasProperty("pets", new
	// BaseMatcher<List<Pet>>() {
	//
	// @Override
	// public boolean matches(Object item) {
	// @SuppressWarnings("unchecked")
	// List<Pet> pets = (List<Pet>) item;
	// Pet pet = pets.get(0);
	// if (pet.getVisits().isEmpty()) {
	// return false;
	// }
	// return true;
	// }
	//
	// @Override
	// public void describeTo(Description description) {
	// description.appendText("Max did not have any visits");
	// }
	// }))).andExpect(view().name("applications/applicationDetails"));
	// }

}
