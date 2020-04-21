package org.springframework.samples.oculusdb.system.integration;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.samples.oculusdb.controllers.ApplicationController;
import org.springframework.samples.oculusdb.services.ApplicationService;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApplicationControllerIntegrationTests {

    private static final int TEST_APPLICATION_ID = 102;

    @Autowired
    private ApplicationController applicationController;

    @Autowired
    private ApplicationService applicationService;

    @Test
    void testShowAppSuccess() throws Exception {
        ModelAndView view = applicationController.showOwner2(TEST_APPLICATION_ID);
        assertEquals(view.getViewName(), "applications/applicationsDetails");
        assertNotNull(view.getModel().get("app"));
    }

    @Test
    void testShowAppHasErrors() throws Exception {
        ModelAndView view = applicationController.showOwner2(TEST_APPLICATION_ID);
        assertNotEquals(view.getViewName(), "applications/applicationsDetailss");
        assertNotNull(view.getModel().get("app"));
    }



}
