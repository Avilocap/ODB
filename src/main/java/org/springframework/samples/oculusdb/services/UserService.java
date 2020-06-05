
package org.springframework.samples.oculusdb.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.oculusdb.model.Administrator;
import org.springframework.samples.oculusdb.model.Role;
import org.springframework.samples.oculusdb.model.User;
import org.springframework.samples.oculusdb.repositories.AdministratorRepository;
import org.springframework.samples.oculusdb.repositories.RoleRepository;
import org.springframework.samples.oculusdb.repositories.UserRepository;
import org.springframework.samples.oculusdb.sponsor.Sponsorship;

import javax.transaction.Transactional;
import java.util.List;

public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private AdministratorRepository administratorRepository;

	String exceptionMessage = "The user already has this role";

	@Transactional
	public User userById(final int id) {
		return this.userRepository.findById(id).orElse(null);
	}

	@org.springframework.transaction.annotation.Transactional
	public Iterable<User> findAll() {
		return this.userRepository.findAll();
	}

	public User userByUsername(String username) {
		return this.userRepository.findByUsername(username);
	}

	@Transactional
	public void saveUser(User user) {
		this.userRepository.save(user);
	}

	@Transactional
	public boolean isAdmin(User user) {
		return user.getRoles().stream().anyMatch(o -> o.getName().equals("ADMIN"));
	}

	public boolean isSponsor(User user) {
		return user.getRoles().stream().anyMatch(o -> o.getName().equals("SPONSOR"));
	}

	public List<Sponsorship> sponsorshipsOfUser(User user) {
		return userRepository.sponoshorShipOfUser(user);
	}

	public Administrator getMainAdministrator() {
		return administratorRepository.mainAdmin("Pedro");
	}

	public String getMainBanner() {
		return administratorRepository.mainAdmin("Pedro").getBannerURL();
	}

	public void changeBanner(String bannerURL) {
		Administrator mainAdmin = this.getMainAdministrator();
		mainAdmin.setBannerURL(bannerURL);
		administratorRepository.save(mainAdmin);
	}

	public void setSponsorRole(String username) {
		// Check if user already contain sponsor role
		User user = this.userByUsername(username);
		if (user.getRoles().stream().noneMatch(o -> o.getName().equals("SPONSOR"))) {
			Role sponsorRole = roleRepository.findRoleByName("SPONSOR");
			user.getRoles().add(sponsorRole);
			this.userRepository.save(user);
		}
		else {
			throw new UnsupportedOperationException(exceptionMessage);
		}
	}

	public void banUser(String username) {
		// Check if user already contain sponsor role
		User user = this.userByUsername(username);
		if (user.isActive()) {
			user.setActive(false);
		}
		else {
			throw new UnsupportedOperationException(exceptionMessage);
		}
	}

	public void unbanUser(String username) {
		// Check if user already contain sponsor role
		User user = this.userByUsername(username);
		if (!user.isActive()) {
			user.setActive(true);
		}
		else {
			throw new UnsupportedOperationException(exceptionMessage);
		}
	}

}
