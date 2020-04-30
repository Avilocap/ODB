package org.springframework.samples.oculusdb.system.integration;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.samples.oculusdb.controllers.UserController;
import org.springframework.samples.oculusdb.model.User;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.MapBindingResult;

import java.util.HashMap;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerIntegrationTests {

    @Autowired
    private UserController userController;

    @Test
    void testInitRegistration() throws Exception {
        ModelMap model = new ModelMap();
        String view = userController.registration(model);
        Assertions.assertEquals(view, "security/registration");
        Assertions.assertNotNull("userForm");


    }

    @Test
    void testRegistrationSuccess() throws Exception {
        ModelMap model = new ModelMap();
        User userform = new User();
        userform.setUsername("prueba22");
        userform.setName("prueba22");
        userform.setSurname("prueba22");
        userform.setEmail("prueba22@gmail.com");
        userform.setPassword("prueba22");
        userform.setGetPasswordConfirm("prueba22");

        BindingResult bindingResult = new MapBindingResult(new HashMap<>(), "");

        String view = userController.registration(userform, bindingResult);
        Assertions.assertEquals(view, "welcome");
    }

    @Test
    void testRegistrationHasErrors() throws Exception {
        ModelMap model = new ModelMap();
        User userform = new User();
        userform.setUsername("");
        userform.setName("");
        userform.setSurname("");
        userform.setEmail("");
        userform.setPassword("");
        userform.setGetPasswordConfirm("");

        BindingResult bindingResult = new MapBindingResult(new HashMap<>(), "");

        String view = userController.registration(userform, bindingResult);
        Assertions.assertEquals(view, "security/registration");
    }

    @Test
    void testInitLogin() throws Exception {
        ModelMap model = new ModelMap();
        String error = null;
        String logout = null;

        String view = userController.login(model, error, logout);
        Assertions.assertEquals(view, "security/login");
    }

    @Test
    void testLoginSuccess() throws Exception {
        String username = "testuser";
        String password = "testuser";

        String view = userController.performLogin(username, password);
        Assertions.assertEquals(view, "redirect:/");
    }

    //falta completarlo

    @Test
    void testLogoutSuccess() throws Exception {
        ModelMap model = new ModelMap();
    }

    //la condicion del metodo de listar usuarios en layout.html no funciona

    @Test
    void testListUsersSuccess() throws Exception {
        ModelMap model = new ModelMap();
        String view = userController.listUsers(model);
        Assertions.assertEquals(view, "users/list");
        Assertions.assertNotNull("users");
    }

    @Test
    void testSetSponsorSuccess() throws Exception {
        ModelMap model = new ModelMap();
        String username = "testuser";
        String view = userController.setSponsor(username);
        Assertions.assertEquals(view, "users/sponsorSet");
    }

    @Test
    void testSetSponsoHasErrors() throws Exception {
        ModelMap model = new ModelMap();
        String username = "manu";
        String view = userController.setSponsor(username);
        Assertions.assertEquals(view, "error");
    }

}
