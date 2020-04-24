package org.springframework.samples.oculusdb.web.e2e;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class UserControllerE2ETests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void testInitRegistration() throws Exception {
		mockMvc.perform(get("/registration")).andExpect(status().isOk())
				.andExpect(view().name("security/registration"));
	}

	// da error porque prueba a meter el usuario en la bd con id=1, pero ya hay uno con
	// ese id

	@Test
	void testRegistrationSuccess() throws Exception {
		mockMvc.perform(post("/registration").param("username", "prueba1").param("name", "prueba1")
				.param("surname", "prueba1").param("email", "prueba1@gmail.com").param("password", "prueba11")
				.param("getPasswordConfirm", "prueba11")).andExpect(status().isOk()).andExpect(view().name("welcome"));
	}

	@Test
	void testRegistrationHasErrors() throws Exception {
		mockMvc.perform(post("/registration").param("username", "").param("name", "").param("surname", "")
				.param("email", "").param("password", "").param("getPasswordConfirm", ""))
				.andExpect(view().name("security/registration"));
	}

	@Test
	void testInitLogin() throws Exception {
		mockMvc.perform(get("/login")).andExpect(status().isOk()).andExpect(view().name("security/login"));
	}

	// no deberia fallar, da error de que no encuentra la vista

	@Test
	void testLoginSuccess() throws Exception {
		mockMvc.perform(post("/login").param("username", "testuser").param("password", "testuser"))
				.andExpect(status().is3xxRedirection()).andExpect(view().name("redirect:/"));
	}

	// no deberia fallar, da error de que no encuentra la vista

	@Test
	void testLoginHasErrors() throws Exception {
		mockMvc.perform(post("/login").param("username", "").param("password", ""))
				.andExpect(status().is3xxRedirection()).andExpect(view().name("redirect:/login"));
	}

}
