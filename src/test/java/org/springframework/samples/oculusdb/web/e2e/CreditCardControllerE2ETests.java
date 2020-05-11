package org.springframework.samples.oculusdb.web.e2e;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
@Disabled
public class CreditCardControllerE2ETests {

	@Autowired
	private MockMvc mockMvc;

	@WithMockUser("testuser")
	@Test
	void testLoadCreditCardFormSuccess() throws Exception {
		mockMvc.perform(get("/creditCard/new")).andExpect(status().isOk())
				.andExpect(view().name("creditCard/creditCardForm.html"));
	}

	/*
	 * @WithMockUser("testuser")
	 *
	 * @Test void testLoadCreditCardFormYaPremium() throws Exception {
	 * mockMvc.perform(get("/creditCard/new")).andExpect(status().isOk())
	 * .andExpect(view().name("creditCard/yaPremium.html")); }
	 */
	@WithMockUser("testuser")
	@Test
	void testLoadCreditCardFormHasErrors() throws Exception {
		mockMvc.perform(get("/creditCardsss/new")).andExpect(status().is4xxClientError());
	}

}
