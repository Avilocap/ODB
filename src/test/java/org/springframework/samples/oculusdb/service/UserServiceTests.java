
package org.springframework.samples.oculusdb.service;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.samples.oculusdb.model.User;
import org.springframework.samples.oculusdb.services.SponsorService;
import org.springframework.samples.oculusdb.services.UserService;
import org.springframework.samples.oculusdb.sponsor.Sponsor;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@SpringBootTest
@Transactional
public class UserServiceTests {

	@Autowired
	private UserService userService;

	int idExtra = (int) 123245245333445L;

	@Autowired
	private SponsorService sponsorService;

	@Test
	public void testIdSponsor() {
		int id = 100;
		Sponsor s = this.sponsorService.sponsorById(id);
		Sponsor s2 = this.sponsorService.sponsorById(id);
		Assertions.assertEquals(s.getName(), s2.getName());
	}

	@Test
	public void testIdUser() {
		int id = 0;
		User s = this.userService.userById(id);
		User s2 = this.userService.userById(id);
		Assertions.assertEquals(s, s2);
	}

	@Test
	public void getAllUsers() {
		Assert.assertNotNull(userService.findAll());
	}

	@Test
	public void userByUsername() {
		List<User> userList = new ArrayList<>((Collection<? extends User>) userService.findAll());
		User user = userList.get(0);
		Assert.assertNotNull(userService.userByUsername(user.getUsername()));
	}

	@Test
	public void userByID() {
		List<User> userList = new ArrayList<>((Collection<? extends User>) userService.findAll());
		User user = userList.get(0);
		Assert.assertNotNull(userService.userById(user.getId()));
	}

	@Test
	public void userByUsernameNegative() {
		Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
			List<User> userList = new ArrayList<>((Collection<? extends User>) userService.findAll());
			User user = userList.get(idExtra);
			Assert.assertNotNull(userService.userByUsername(user.getUsername()));
		});

	}

	@Test
	public void userByIDNegative() {
		Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
			List<User> userList = new ArrayList<>((Collection<? extends User>) userService.findAll());
			User user = userList.get(idExtra);
			Assert.assertNotNull(userService.userById(user.getId()));
		});
	}

	@Test
	public void editUserName() {
		List<User> userList = new ArrayList<>((Collection<? extends User>) userService.findAll());
		User user = userList.get(0);
		String initialName = user.getName();
		String newName = "Pepe";
		user.setName(newName);
		userService.saveUser(user);
		Assert.assertNotEquals(user.getName(), initialName);
	}

	@Test
	public void editUserEmail() {
		List<User> userList = new ArrayList<>((Collection<? extends User>) userService.findAll());
		User user = userList.get(0);
		String initialEmail = user.getEmail();
		String newEmail = "nuevomaildepepe@mail.com";
		user.setEmail(newEmail);
		userService.saveUser(user);
		Assert.assertNotEquals(user.getEmail(), initialEmail);
	}

	@Test
	public void editUserEmailNotOk() {
		List<User> userList = new ArrayList<>((Collection<? extends User>) userService.findAll());
		User user = userList.get(0);
		String initialEmail = user.getEmail();
		String newEmail = "";
		user.setEmail(newEmail);
		userService.saveUser(user);
		Assert.assertNotEquals(user.getEmail(), initialEmail);
	}

	@Test
	public void setSponsorRole() {
		User user = this.userService.userById(103);
		int sizeOfRoles = user.getRoles().size();
		userService.setSponsorRole(user.getUsername());
		userService.saveUser(user);
		Assert.assertNotEquals(sizeOfRoles, user.getRoles().size());
	}

	@Test
	public void setSponsorRoleWithRoleAlreadyAssigned() {
		User user = this.userService.userById(100);
		userService.saveUser(user);
		Assertions.assertThrows(UnsupportedOperationException.class, () -> {
			userService.setSponsorRole(user.getUsername());
		});
	}

	@Test
	public void isAdmin() {
		User user = this.userService.userById(100);
		Assert.assertTrue(userService.isAdmin(user));
	}

	@Test
	public void isNotAdmin() {
		List<User> userList = new ArrayList<>((Collection<? extends User>) userService.findAll());
		User user = userList.get(userList.size() - 1);
		Assert.assertFalse(userService.isAdmin(user));
	}

	@Test
	public void isSponsor() {
		List<User> userList = new ArrayList<>((Collection<? extends User>) userService.findAll());
		User user = userList.get(2);
		userService.setSponsorRole(user.getUsername());
		Assert.assertTrue(userService.isSponsor(user));
	}

	@Test
	public void isNotSponsor() {
		User user = this.userService.userById(103);
		Assert.assertFalse(userService.isSponsor(user));
	}

	@Test
	public void banUser() {
		User user = this.userService.userById(104);
		userService.banUser(user.getUsername());
		Assert.assertFalse(user.isActive());
	}

	@Test
	public void banUserAlreadyBanned() {
		User user = this.userService.userById(103);
		Assertions.assertThrows(UnsupportedOperationException.class, () -> {
			userService.banUser(user.getUsername());
		});
	}

	@Test
	public void unbanUser() {
		User user = this.userService.userById(103);
		userService.unbanUser(user.getUsername());
		Assert.assertTrue(user.isActive());
	}

	@Test
	public void unbanUserAlreadyUnbanned() {
		User user = this.userService.userById(104);
		Assertions.assertThrows(UnsupportedOperationException.class, () -> {
			userService.unbanUser(user.getUsername());
		});
	}

	@Test
	public void changeBannerTest() {
		userService.changeBanner("Https://newBanner.com");
		Assertions.assertTrue(userService.getMainBanner().equals("Https://newBanner.com"));
	}

}
