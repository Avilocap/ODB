package org.springframework.samples.oculusdb.system;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.samples.oculusdb.controllers.CreditCardController;
import org.springframework.samples.oculusdb.services.CreditCardService;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class CreditCardControllerTests {

	@Autowired
	private CreditCardController creditCardController;

	@MockBean
	private CreditCardService creditCardService;

	@Autowired
	private MockMvc mockMvc;

	@WithMockUser("miguel")
	@Test
	void testInitCreditCardForm() throws Exception {
		mockMvc.perform(get("/creditCard/new")).andExpect(status().isOk())
				.andExpect(view().name("creditCard/creditCardForm.html"));
	}

	@WithMockUser("testuser")
	@Test
	void testInitCreditCardFormHasErrors() throws Exception {
		mockMvc.perform(get("/creditCard/neww")).andExpect(status().is4xxClientError());
	}

}
