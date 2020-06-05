package org.springframework.samples.oculusdb.web.e2e;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
@Transactional
// @TestPropertySource(locations = "classpath:application-development.properties")
public class SponsorshipControllerE2ETests {

	@Autowired
	private MockMvc mockMvc;

	@WithMockUser(username = "testuser")
	@Test
	void testListSponsorshipsSuccess() throws Exception {
		mockMvc.perform(get("/sponsorship/list")).andExpect(status().isOk()).andExpect(view().name("sponsorship/list"));
	}

	@WithMockUser(username = "testuser")
	@Test
	void testListSponsorshipsHasErrors() throws Exception {
		mockMvc.perform(get("/sponsorshipsss/list")).andExpect(status().is4xxClientError());
	}

	@WithMockUser(username = "testuser")
	@Test
	void testAddSponsorshipSuccess() throws Exception {
		mockMvc.perform(get("/sponsorship/new")).andExpect(status().isOk()).andExpect(view().name("sponsorship/new"));
	}

	@WithMockUser(username = "testuser")
	@Test
	void testAddSponsorshipHasErrors() throws Exception {
		mockMvc.perform(get("/sponsorshipsss/new")).andExpect(status().is4xxClientError());
	}

	@WithMockUser(username = "testuser")
	@Test
	void testAddSponsorShipSuccesInit() throws Exception {

		mockMvc.perform(post("/sponsorship/new").with(csrf()).param("title", "New Sponsorship").param("attachmentUrl",
				"newsponsor.com")).andExpect(status().isOk()).andExpect(view().name("sponsorship/creacion"));

	}

	@WithMockUser(username = "testuser")
	@Test
	void testAddSponsorshipErrors() throws Exception {
		mockMvc.perform(post("/sponsorship/new").with(csrf()).param("title", "New Sponsorship"))
				.andExpect(model().attributeHasErrors("sponsorship"))
				.andExpect(model().attributeHasFieldErrors("sponsorship", "attachmentUrl")).andExpect(status().isOk())
				.andExpect(view().name("sponsorship/new"));
	}

}
