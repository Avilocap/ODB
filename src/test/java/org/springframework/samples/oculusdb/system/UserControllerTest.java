package org.springframework.samples.oculusdb.system;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.samples.oculusdb.controllers.SponsorController;
import org.springframework.samples.oculusdb.controllers.UserController;
import org.springframework.samples.oculusdb.services.UserService;
import org.springframework.samples.oculusdb.services.UserServiceImpl;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class UserControllerTest {




    @MockBean
    private UserService userService;

    @Autowired
    private UserController userController;

    @Autowired
    private MockMvc mockMvc;

    /*

    @Test
    void testInitRegistrationSucces() throws Exception {
        mockMvc.perform(get("/registration")).andExpect(status().isOk())
                .andExpect(view().name("security/registration"));

    }

    @Test
    void testInitRegistrationError() throws Exception {
        mockMvc.perform(get("/registrations")).andExpect(status().is4xxClientError());

    }

    @Test
    void testRegistrationSucces() throws Exception {
        mockMvc.perform(post("/registration").param("username", "juan23").param("name", "Juan")
                .param("email", "juan23@gmail.com")
                .param("password", "juan123456")
                .param("passwordConfirm", "juan123456"))
                .andExpect(status().isOk())
                .andExpect(view().name("welcome"));

    }

    @Test
    void testRegistrationHasErrors() throws Exception {
        mockMvc.perform(post("/registration").param("username", "juan23").param("name", "Juan")
                .param("password", "juan123456")
                .param("passwordConfirm", "juan123456"))
                .andExpect(status().isOk())
                .andExpect(model().attributeHasFieldErrors("user", "email"))
                .andExpect(view().name("security/registration"));

    }

    @Test
    void testRegistrationHasErrors2() throws Exception {
        mockMvc.perform(post("/registration").param("username", "juan23").param("name", "Juan")
                .param("email", "juan23@gmail.com")
                .param("password", "juan12")
                .param("passwordConfirm", "juan12"))
                .andExpect(status().isOk())
                .andExpect(model().attributeHasErrors("user"))
                .andExpect(model().attributeHasFieldErrors("user", "password"))
                .andExpect(view().name("security/registration"));

    }

    @Test
    void testRegistrationHasErrors3() throws Exception {
        mockMvc.perform(post("/registration").param("username", "juan23").param("email", "juan23@gmail.com")
                .param("password", "juan123456")
                .param("passwordConfirm", "juan123456"))
                .andExpect(status().isOk())
                .andExpect(model().attributeHasErrors("user"))
                .andExpect(model().attributeHasFieldErrors("user", "name"))
                .andExpect(view().name("security/registration"));

    }


    @Test
    void testRegistrationHasErrors4() throws Exception {
        mockMvc.perform(post("/registration").param("name", "Juan")
                .param("email", "juan23@gmail.com")
                .param("password", "juan123456")
                .param("passwordConfirm", "juan123456"))
                .andExpect(status().isOk())
                .andExpect(model().attributeHasFieldErrors("user", "username"))
                .andExpect(view().name("security/registration"));

    }

    @Test
    void testRegistrationHasErrors5() throws Exception {
        mockMvc.perform(post("/registration").param("username", "juan23").param("name", "Juan")
                .param("email", "juan23@gmail.com"))
                .andExpect(status().isOk())
                .andExpect(model().attributeHasErrors("user"))
                .andExpect(model().attributeHasFieldErrors("user", "password"))
                .andExpect(view().name("security/registration"));

    }


    @Test
    void testRegistrationHasErrors6() throws Exception {
        mockMvc.perform(post("/registration").param("username", "juan23").param("name", "Juan")
                .param("email", "juan23@gmail.com")
                .param("password", "juan123456")
                .param("passwordConfirm", "juan123457"))
                .andExpect(status().isOk())
                .andExpect(model().attributeHasErrors("user"))
                .andExpect(model().attributeHasFieldErrors("user", "passwordConfirm"))
                .andExpect(view().name("security/registration"));

    }

    @Test
    void testInitLogin() throws Exception {
        mockMvc.perform(get("/login")).andExpect(status().isOk()).andExpect(view().name("security/login"));
    }


    @Test
    void testLoginSuccess() throws Exception {
        mockMvc.perform(post("/login").param("username", "testuser").param("password", "testuser"))
                .andExpect(status().is3xxRedirection());
    }


    @Test
    void testLoginHasErrors() throws Exception {
        mockMvc.perform(post("/login").param("username", "").param("password", ""))
                .andExpect(status().is3xxRedirection());
    }

    @WithMockUser("testuser")
    @Test
    void testListUsersSuccess() throws Exception {
        mockMvc.perform(get("/users/list")).andExpect(status().isOk())
                .andExpect(view().name("users/list"));
    }

    @WithMockUser("adri")
    @Test
    void testListUsersHasErrors() throws Exception {
        mockMvc.perform(get("/users/list")).andExpect(status().isOk())
                .andExpect(view().name("error"));
    }


    @WithMockUser("testuser")
    @Test
    void testSetSponsorSuccess() throws Exception {
        mockMvc.perform(get("/users/setSponsor/{username}", "testuser")).andExpect(status().isOk())
                .andExpect(view().name("users/sponsorSet"));
    }


    @WithMockUser("adri")
    @Test
    void testSetSponsorHasError() throws Exception {
        mockMvc.perform(get("/users/setSponsor/{username}", "testuser")).andExpect(status().isOk())
                .andExpect(view().name("error"));
    }

*/

}

