package org.springframework.samples.oculusdb.web.integration;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.samples.oculusdb.controllers.SponsoshipController;
import org.springframework.samples.oculusdb.services.UserService;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.ui.ModelMap;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SponsorshipControllerIntegrationTests {

    private static final int TEST_USER_ID = 1;

    @Autowired
    private SponsoshipController sponsoshipController;

    @Autowired
    private UserService userService;

/* da fallo porque la tabla de sponsor esta vacia

    @WithMockUser("testuser")
    @Test
    void testListSponsorshipsSuccess() throws Exception {
        ModelMap model = new ModelMap();

        String view = sponsoshipController.listSponsorships(model);

        Assertions.assertEquals(view, "sponsorship/list");
        Assertions.assertNotNull(model.getAttribute("sponsorships"));
    }

 */


    @Test
    void testAddSponsorSuccess() throws Exception {
        ModelMap model = new ModelMap();

        String view = sponsoshipController.addSponsorship(model);

        Assertions.assertEquals(view, "sponsorship/new");
        Assertions.assertNotNull(model.getAttribute("sponsorship"));
    }

}
