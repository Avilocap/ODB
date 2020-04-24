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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class UserControllerE2ETests {

    @Autowired
    private MockMvc mockMvc;

    private static String TEST_USERNAME_1 = "testuser";
    private static String TEST_USERNAME_2 = "manu";

    @Test
    void testInitRegistration() throws Exception {
        mockMvc.perform(get("/registration"))
                .andExpect(status().isOk())
                .andExpect(view().name("security/registration"));
    }

    //da error porque prueba a meter el usuario en la bd con id=1, pero ya hay uno con ese id

    @Test
    void testRegistrationSuccess() throws Exception {
        mockMvc.perform(post("/registration")
        .param("username", "prueba1")
        .param("name", "prueba1")
        .param("surname", "prueba1")
        .param("email", "prueba1@gmail.com")
        .param("password", "prueba11")
        .param("getPasswordConfirm", "prueba11"))
                .andExpect(status().isOk())
                .andExpect(view().name("welcome"));
    }

    @Test
    void testRegistrationHasErrors() throws Exception {
        mockMvc.perform(post("/registration")
                .param("username", "")
                .param("name", "")
                .param("surname", "")
                .param("email", "")
                .param("password", "")
                .param("getPasswordConfirm", ""))
                .andExpect(view().name("security/registration"));
    }

    @Test
    void testInitLogin() throws Exception {
        mockMvc.perform(get("/login"))
                .andExpect(status().isOk())
                .andExpect(view().name("security/login"));
    }

    //no deberia fallar, da error de que no encuentra la vista

    @Test
    void testLoginSuccess() throws Exception {
        mockMvc.perform(post("/login")
        .param("username", "testuser")
        .param("password", "testuser"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/"));
    }

    //no deberia fallar, da error de que no encuentra la vista

    @Test
    void testLoginHasErrors() throws Exception {
        mockMvc.perform(post("/login")
                .param("username", "")
                .param("password", ""))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/login"));
    }

    @Test
    @WithMockUser(username = "testuser")
    void testLogoutSuccess() throws Exception {
        mockMvc.perform(get("/logout"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/login?logout"));
    }

    @Test
    @WithMockUser(username = "testuser")
    void testLogoutHasErrors() throws Exception {
        mockMvc.perform(get("/logoutss"))
                .andExpect(status().is4xxClientError());
    }

    @Test
    @WithMockUser(username = "testuser")
    void testListUsersSuccess() throws Exception {
        mockMvc.perform(get("/users/list"))
                .andExpect(status().isOk())
                .andExpect(view().name("users/list"));
    }

    @Test
    @WithMockUser(username = "manu")
    void testListUsersHasErrors() throws Exception {
        mockMvc.perform(get("/users/list"))
                .andExpect(status().isOk())
                .andExpect(view().name("error"));
    }

    //falla porque dice que el usuario testuser ya tiene el rol de SPONSOR, aunque solo tiene el de ADMIN

    @Test
    @WithMockUser(username = "testuser")
    void testSetSponsorSuccess() throws Exception {
        mockMvc.perform(get("/users/setSponsor/{username}", TEST_USERNAME_1))
                .andExpect(status().isOk())
                .andExpect(view().name("users/sponsorSet"));
    }

    @Test
    @WithMockUser(username = "manu")
    void testSetSponsorHasErrors() throws Exception {
        mockMvc.perform(get("/users/setSponsor/{username}", TEST_USERNAME_2))
                .andExpect(status().isOk())
                .andExpect(view().name("error"));
    }

}
