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

import org.bouncycastle.jcajce.provider.asymmetric.ec.KeyFactorySpi;
import org.junit.jupiter.api.BeforeEach;
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

import org.springframework.samples.oculusdb.application.Comments;
import org.springframework.samples.oculusdb.category.Category;
import org.springframework.samples.oculusdb.controllers.ApplicationController;
import org.springframework.samples.oculusdb.model.Application;
import org.springframework.samples.oculusdb.model.TypeOfApp;
import org.springframework.samples.oculusdb.model.TypeOfGameplay;
import org.springframework.samples.oculusdb.platform.Platform;
import org.springframework.samples.oculusdb.services.ApplicationService;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;

import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
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
class ApplicationControllerTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ApplicationService applicationService;

	private static final int TEST_APPLICATION_ID = 2;
	private Application application1;

	@BeforeEach
	void setup() {

		application1 = new Application();
		application1.setId(TEST_APPLICATION_ID);
		application1.setName("FIFA");
		application1.setDescription("jajjjdaffwefQFFE");
		application1.setReleaseDate(LocalDate.of(1970,  01, 18));
		application1.setPrice(30.00);
		application1.setWebsite("www.aaaaaa.com");
		application1.setCompany("EA");
		application1.setPicture("wehfwFEEFGGDCDASD.jpeg");
		application1.setTypeOfApp(TypeOfApp.EXPERIENCE);
		application1.setTypeOfGameplay(TypeOfGameplay.COOP);
		Category category = new Category();
		category.setId(30);
		category.setTitle("juego");
		category.setDescription(" de aja alq lq");
		Collection<Application> cat2 = new HashSet<>();
		category.setApplications(cat2);
		application1.setCategory(category);
		application1.setIncomeEstimation(13014);
		application1.setTotalReviews(600);
		application1.setLanguage("ENGLISH");
		application1.setSalesEstimation(400);
		Collection<Comments> comments = new HashSet<>();
		application1.setComments(comments);
		application1.setOculusId("134534534");
		Platform platform = new Platform();
		platform.setId(33);
		platform.setTitle("sport");
		platform.setDescription("juegos de sport");
		application1.setPlatform(platform);

		given(this.applicationService.findApplicationById(TEST_APPLICATION_ID).get()).willReturn(application1);

	}

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
		mockMvc.perform(get("/applications/appInfo/{appId}/favorite", 9)).andExpect(status().isOk());
	}

	@Test
	@WithMockUser("testuser")
	void testInitFindForm() throws Exception {
		mockMvc.perform(get("/applications/appInfo/{appId}", 2)).andExpect(status().isOk());
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
		mockMvc.perform(get("/applications").param("lastName", "Unknown Surname"))
				.andExpect(status().is4xxClientError());
	}

	@WithMockUser("testuser")
	@Test
	void testGetApplication() throws Exception {
		mockMvc.perform(get("/applications/get").param("id", "1368187813209608")).andExpect(status().isOk());
	}

	@WithMockUser("testuser")
	@Test
	void testInitUpdateAppForm() throws Exception {
		mockMvc.perform(get("/applications/appInfo/edit", TEST_APPLICATION_ID))
				.andExpect(status().isOk()).andExpect(model().attributeExists("application"))
				.andExpect(model().attribute("app", hasProperty("name", is("Gravity Sketch"))))
				//.andExpect(model().attribute("app", hasProperty("description", is(""))))
				.andExpect(view().name("applications/createOrUpdateApplicationForm"));
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

	void testInitAddToFavorites() throws Exception {
		mockMvc.perform(get("/applications/appInfo/{appId}/favorite", TEST_APPLICATION_ID)).andExpect(status().isOk())
				.andExpect(view().name("applications/favorites"));
	}

	@Test
	@WithMockUser("testuser")
	void testAddToFavoritesSuccess() throws Exception{
		mockMvc.perform(get("/applications/appInfo/{appId}/favorite", TEST_APPLICATION_ID))
				.andExpect(status().isOk())
			//	.andExpect(model().attribute("app", hasProperty("name", is("Gravity Sketch"))))
			//	.andExpect(model().attribute("app", hasProperty("company", is("Gravity Sketch"))))
				.andExpect(view().name("applications/favorites"));
	}

	@Test
	@WithMockUser("testuser")
	void testAddToFavoritesHasErrors() throws Exception {
		mockMvc.perform(get("/applications/appInfo/{appId}/favorite", TEST_APPLICATION_ID)).andExpect(status().isOk())
				.andExpect(model().attribute("app", hasProperty("name", is("FIFA 20"))))
				.andExpect(model().attribute("app", hasProperty("company", is("EA SPORTS"))))
				.andExpect(view().name("applications/favorites"));
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
				.andExpect(status().isOk())
				.andExpect(model().attribute("application", hasProperty("name", is("Gravity Sketch"))))
				.andExpect(model().attribute("application", hasProperty("company", is("Gravity Sketch"))))
				.andExpect(view().name("applications/favorites"));
	}

	@Test
	@WithMockUser("testuser")
	void testDeleteFavoriteHasErrors() throws Exception {
		mockMvc.perform(get("/applications/favorites/delete").param("appId", String.valueOf(TEST_APPLICATION_ID)))
				.andExpect(status().isOk())
			//	.andExpect(model().attribute("application", hasProperty("name", is("testuser"))))
			//	.andExpect(model().attribute("application", hasProperty("company", is("true"))))
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
	void testShowAppSuccess() throws Exception {
		mockMvc.perform(get("/applications/appInfo/{appId}", TEST_APPLICATION_ID)).andExpect(status().isOk())
				.andExpect(model().attribute("application", hasProperty("name", is("Gravity Sketch"))))
				.andExpect(model().attribute("application", hasProperty("description", is(
						"Gravity Sketch is an intuitive sketching experience giving you extensive access to tools for creative exploration. You can fully express your ideas in real-time at any scale, from initial conception to model. Create loose free form sketches, detailed models, expansive scenes, and artwork unrestricted.\n"
								+ "\n"
								+ "Export your work as an image or model for use in other phases of your workflow. Gravity Sketch is a tool for the designer who makes every stroke count. Join the community of creatives defining new design workflows.\n"
								+ "\n"
								+ "“The ability to start in 3D and stay in 3D has been the most transformative aspect of the workflow provided by Gravity Sketch, allowing me to create a 3D “napkin sketch” straight from my brain.”\n"
								+ "\n" + "      - Saiful Haque, Concept Artist, Avatar Sequels\n" + "\n"
								+ "- 6 Creation Tools\n" + "- 4 Creation Layers\n" + "- 4 Environments\n"
								+ "- Image import (.jpg and .png)\n" + "- Snapshot Tool for quick image capture\n"
								+ "- Export/Import .OBJ\n"
								+ "- Upload to Landing Pad (a 3D Cloud file management Platform)"))))
				.andExpect(model().attribute("application", hasProperty("releaseDate", is("1970-01-18"))))
				.andExpect(model().attribute("application", hasProperty("price", is("29.99"))))
				.andExpect(model().attribute("application", hasProperty("typeOfGameplay", is("0"))))
				.andExpect(model().attribute("application", hasProperty("typeOfApp", is("0"))))
				.andExpect(model().attribute("application", hasProperty("platform", is("1"))))
				.andExpect(model().attribute("application", hasProperty("category", is("1"))))
				.andExpect(
						model().attribute("application", hasProperty("website", is("https://www.gravitysketch.com/"))))
				.andExpect(model().attribute("application", hasProperty("company", is("Gravity Sketch"))))
				.andExpect(model().attribute("application", hasProperty("incomeEstimation", is("57580, "))))
				.andExpect(model().attribute("application", hasProperty("salesEstimation", is("1920"))))
				.andExpect(model().attribute("application", hasProperty("totalReviews", is("96"))))
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
