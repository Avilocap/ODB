package org.springframework.samples.oculusdb.system;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.samples.oculusdb.controllers.SponsorshipController;
import org.springframework.samples.oculusdb.services.SponsorShipService;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class SponsorshipControllerTests {

	@MockBean
	private SponsorShipService sponsorShipService;

	@Autowired
	private SponsorshipController sponsorshipController;

	@Autowired
	private MockMvc mockMvc;

	@WithMockUser("testuser")
	@Test
	void testInitShowSponsorshipsList() throws Exception {
		mockMvc.perform(get("/sponsorship/list")).andExpect(status().isOk()).andExpect(view().name("sponsorship/list"));
	}

	@WithMockUser("testuser")
	@Test
	void testShowSponsorshipsListSuccess() throws Exception {
		mockMvc.perform(get("/sponsorship/list")).andExpect(status().isOk())
				.andExpect(model().attributeExists("sponsorships")).andExpect(view().name("sponsorship/list"));
	}

	@WithMockUser("adri")
	@Test
	void testShowSponsorshipsListError() throws Exception {
		mockMvc.perform(get("/sponsorship/list")).andExpect(status().isOk()).andExpect(view().name("error"));
	}

	@WithMockUser("testuser")
	@Test
	void testShowSponsorshipsListError2() throws Exception {
		mockMvc.perform(get("/sponsorship/lists")).andExpect(status().is4xxClientError());
	}

	@WithMockUser("testuser")
	@Test
	void testInitAddSponsorSuccess() throws Exception {
		mockMvc.perform(get("/sponsorship/new")).andExpect(status().isOk()).andExpect(view().name("sponsorship/new"));
	}

	@WithMockUser("testuser")
	@Test
	void testInitAddSponsorshipErrors() throws Exception {
		mockMvc.perform(get("/sponsorshipss/new")).andExpect(status().is4xxClientError());
	}

	/*
	 * @WithMockUser("testuser")
	 *
	 * @Test void testAddSponsorshipSuccess() throws Exception {
	 * mockMvc.perform(post("/sponsorship/new").param("title", "nuevo sponsorship")
	 * .param("attachmentURL", "sponsornew.com")) .andExpect(status().isOk())
	 * .andExpect(view().name("sponsorship/creacion"));
	 *
	 * }
	 *
	 * @WithMockUser("testuser")
	 *
	 * @Test void testAddSponsorshipHasErrors() throws Exception {
	 * mockMvc.perform(post("/sponsorship/new").with(csrf()).param("title",
	 * "nuevo sponsorship"))
	 * .andExpect(status().isOk()).andExpect(model().attributeHasErrors("sponsorship"))
	 * .andExpect(model().attributeHasFieldErrors("sponsorship", "attachmentUrl"))
	 * .andExpect(view().name("sponsorship/creacion"));
	 *
	 * }
	 *
	 *
	 */

}
