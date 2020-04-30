package org.springframework.samples.oculusdb.system.integration;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.samples.oculusdb.controllers.SponsorshipController;
import org.springframework.samples.oculusdb.services.UserService;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.ui.ModelMap;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SponsorshipControllerIntegrationTests {

    private static final int TEST_USER_ID = 1;

    @Autowired
    private SponsorshipController sponsorshipController;

    @Autowired
    private UserService userService;

    @Test
    void testListSponsorshipsSuccess() throws Exception {
        ModelMap model = new ModelMap();

        String view = sponsorshipController.listSponsorships(model);

        Assertions.assertEquals(view, "sponsorship/list");
    }

}
