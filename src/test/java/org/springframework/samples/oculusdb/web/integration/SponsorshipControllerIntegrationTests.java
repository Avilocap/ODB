package org.springframework.samples.oculusdb.web.integration;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.samples.oculusdb.controllers.SponsorshipController;
import org.springframework.samples.oculusdb.services.UserService;
import org.springframework.samples.oculusdb.sponsor.Sponsorship;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.MapBindingResult;

import java.util.Collections;

@Transactional
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SponsorshipControllerIntegrationTests {

	private static final int TEST_USER_ID = 1;

	@Autowired
	private SponsorshipController sponsorshipController;

	@Autowired
	private UserService userService;

	@WithMockUser("testuser")
	@Test
	void testListSponsorshipsSuccess() throws Exception {
		ModelMap modelMap = new ModelMap();
		String view = sponsorshipController.listSponsorships(modelMap);
		Assertions.assertEquals(view, "sponsorship/list");
		Assertions.assertNotNull(modelMap.getAttribute("sponsorships"));
	}

	@WithMockUser("josema")
	@Test
	void testListSponsorshipsHasErrors1() throws Exception {
		ModelMap modelMap = new ModelMap();
		String view = sponsorshipController.listSponsorships(modelMap);
		Assertions.assertEquals(view, "error");
	}

	@WithMockUser("testuser")
	@Test
	void testListSponsorshipsHasErrors2() throws Exception {
		ModelMap modelMap = new ModelMap();
		String view = sponsorshipController.listSponsorships(modelMap);
		Assertions.assertNotEquals(view, "sponsorship/listt");
	}

	@Test
	void testAddSponsorSuccess() throws Exception {
		ModelMap model = new ModelMap();

		String view = sponsorshipController.addSponsorship(model);

		Assertions.assertEquals(view, "sponsorship/new");
		Assertions.assertNotNull(model.getAttribute("sponsorship"));
	}

	@Test
	void testAddSponsorshipHasErrors() throws Exception {
		ModelMap model = new ModelMap();
		String view = sponsorshipController.addSponsorship(model);
		Assertions.assertNotEquals(view, "sponsorship/neww");
	}

	@WithMockUser("testuser")
	@Test
	void testNewSponsorshipSuccess() throws Exception {
		Sponsorship sponsorship = new Sponsorship();
		sponsorship.setTitle("Sponsorship");
		sponsorship.setAttachmentUrl("www.sponsorship.com");
		BindingResult result = new MapBindingResult(Collections.emptyMap(), "");
		ModelMap modelMap = new ModelMap();
		String view = sponsorshipController.newSponsorhip(sponsorship, result, modelMap);
		Assertions.assertEquals(view, "sponsorship/creacion");
	}

	@WithMockUser("testuser")
	@Test
	void testNewSponsorshipHasErrors1() throws Exception {
		Sponsorship sponsorship = new Sponsorship();
		sponsorship.setTitle("Sponsorship");
		BindingResult result = new MapBindingResult(Collections.emptyMap(), "");
		result.reject("attachmentUrl", "Required");
		ModelMap modelMap = new ModelMap();
		String view = sponsorshipController.newSponsorhip(sponsorship, result, modelMap);
		Assertions.assertEquals(view, "sponsorship/new");
	}

	@WithMockUser("testuser")
	@Test
	void testNewSponsorshipHasErrors2() throws Exception {
		Sponsorship sponsorship = new Sponsorship();
		sponsorship.setAttachmentUrl("www.sponsorship.com");
		BindingResult result = new MapBindingResult(Collections.emptyMap(), "");
		result.reject("title", "Required");
		ModelMap modelMap = new ModelMap();
		String view = sponsorshipController.newSponsorhip(sponsorship, result, modelMap);
		Assertions.assertEquals(view, "sponsorship/new");
	}

	@WithMockUser("testuser")
	@Test
	void testNewSponsorshipHasErrors3() throws Exception {
		Sponsorship sponsorship = new Sponsorship();
		sponsorship.setTitle("Sponsorship");
		sponsorship.setAttachmentUrl("www.sponsorship.com");
		BindingResult result = new MapBindingResult(Collections.emptyMap(), "");
		ModelMap modelMap = new ModelMap();
		String view = sponsorshipController.newSponsorhip(sponsorship, result, modelMap);
		Assertions.assertNotEquals(view, "sponsorship/neww");
	}

	@WithMockUser("miguel")
	@Test
	void testNewSponsorshipSuccessMiguel() throws Exception {
		Sponsorship sponsorship = new Sponsorship();
		sponsorship.setTitle("Sponsorship");
		sponsorship.setAttachmentUrl("www.sponsorship.com");
		BindingResult result = new MapBindingResult(Collections.emptyMap(), "");
		ModelMap modelMap = new ModelMap();
		String view = sponsorshipController.newSponsorhip(sponsorship, result, modelMap);
		Assertions.assertEquals(view, "sponsorship/creacion");
	}

	@WithMockUser("miguel")
	@Test
	void testNewSponsorshipHasErrors1Miguel() throws Exception {
		Sponsorship sponsorship = new Sponsorship();
		sponsorship.setTitle("Sponsorship");
		BindingResult result = new MapBindingResult(Collections.emptyMap(), "");
		result.reject("attachmentUrl", "Required");
		ModelMap modelMap = new ModelMap();
		String view = sponsorshipController.newSponsorhip(sponsorship, result, modelMap);
		Assertions.assertEquals(view, "sponsorship/new");
	}

	@WithMockUser("miguel")
	@Test
	void testNewSponsorshipHasErrors2Miguel() throws Exception {
		Sponsorship sponsorship = new Sponsorship();
		sponsorship.setAttachmentUrl("www.sponsorship.com");
		BindingResult result = new MapBindingResult(Collections.emptyMap(), "");
		result.reject("title", "Required");
		ModelMap modelMap = new ModelMap();
		String view = sponsorshipController.newSponsorhip(sponsorship, result, modelMap);
		Assertions.assertEquals(view, "sponsorship/new");
	}

}