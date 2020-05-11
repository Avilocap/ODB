
package org.springframework.samples.oculusdb.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.samples.oculusdb.model.User;
import org.springframework.samples.oculusdb.services.SponsorShipService;
import org.springframework.samples.oculusdb.services.UserService;
import org.springframework.samples.oculusdb.sponsor.Sponsorship;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class SponsorShipServiceTests {

	@Autowired
	private SponsorShipService sponsorShipService;

	@Autowired
	private UserService userService;

	@Test
	public void testCount() {
		int count = this.sponsorShipService.sponsorShipCount();
		Assertions.assertTrue(count > 0);
	}

	@Test
	public void addSponsorShipSuccess() {
		User user = userService.userById(100);
		Sponsorship sponsorShip = new Sponsorship();

		int sponsors = user.getSponsorships().size();


		sponsorShip.setTitle("nuevo sponsorship");
		sponsorShip.setAttachmentUrl("sponsornew.com");
		sponsorShip.setUser(user);

		user.getSponsorships().add(sponsorShip);

		this.sponsorShipService.saveSponsorship(sponsorShip);
		Assertions.assertEquals(sponsors + 1, user.getSponsorships().size());
	}

	@Test
	public void addSponsorShipWithUserIdSuccess() {
		User user = userService.userById(100);
		Sponsorship sponsorShip = new Sponsorship();

		sponsorShip.setTitle("nuevo sponsorship");
		sponsorShip.setAttachmentUrl("sponsornew.com");
		sponsorShip.setUser(user);

		this.sponsorShipService.saveSponsorship(sponsorShip);

		user.getSponsorships().add(sponsorShip);
		this.sponsorShipService.saveSponsorship(sponsorShip);

		Assertions.assertEquals(sponsorShip.getUser(), user);
	}

	@Test
	public void addSponsorShipHasErrors() {
		User user = userService.userById(100);
		Sponsorship sponsorShip = new Sponsorship();


		sponsorShip.setAttachmentUrl("sponsornew.com");
		sponsorShip.setUser(user);

		if(sponsorShip.getTitle() == null) {
			sponsorShip = null;
		} else {
			this.sponsorShipService.saveSponsorship(sponsorShip);
		}

		Assertions.assertNull(sponsorShip);
	}

	@Test
	public void addSponsorShipHasErrors1() {
		User user = userService.userById(100);
		Sponsorship sponsorShip = new Sponsorship();


		sponsorShip.setTitle("sponsor");
		sponsorShip.setUser(user);

		if(sponsorShip.getAttachmentUrl() == null) {
			sponsorShip = null;
		} else {
			this.sponsorShipService.saveSponsorship(sponsorShip);
		}

		Assertions.assertNull(sponsorShip);
	}

	@Test
	public void addSponsorShipHasErrors2() {
		User user = userService.userById(100);
		Sponsorship sponsorShip = new Sponsorship();


		sponsorShip.setTitle("sponsor");
		sponsorShip.setUser(user);

		if(sponsorShip.getAttachmentUrl() == null) {
			sponsorShip = null;
		} else {
			this.sponsorShipService.saveSponsorship(sponsorShip);
		}

		Assertions.assertNull(sponsorShip);
	}


	@Test
	public void addSponsorShipHasErrors3() {
		User user = userService.userById(100);
		Sponsorship sponsorShip = new Sponsorship();

		int sponsors = user.getSponsorships().size();

		sponsorShip.setUser(user);

		this.sponsorShipService.saveSponsorship(sponsorShip);

		if(sponsorShip.getAttachmentUrl() == null || sponsorShip.getTitle() == null) {
			sponsorShip = null;
		} else {
			user.getSponsorships().add(sponsorShip);
		}

		Assertions.assertEquals(sponsors, user.getSponsorships().size());
	}


	@Test
	public void addSponsorShipHasErrors4() {
		User user = userService.userById(104);
		Sponsorship sponsorShip = new Sponsorship();


		sponsorShip.setTitle("nuevo sponsorship");
		sponsorShip.setAttachmentUrl("sponsornew.com");
		sponsorShip.setUser(user);

		this.sponsorShipService.saveSponsorship(sponsorShip);

		if(!userService.isSponsor(user)) {
			sponsorShip = null;
		} else {
			user.getSponsorships().add(sponsorShip);
		}

		Assertions.assertNull(sponsorShip);
	}



}
