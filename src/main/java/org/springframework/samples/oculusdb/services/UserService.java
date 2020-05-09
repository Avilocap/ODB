
package org.springframework.samples.oculusdb.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.oculusdb.model.Application;
import org.springframework.samples.oculusdb.model.Role;
import org.springframework.samples.oculusdb.model.User;
import org.springframework.samples.oculusdb.repositories.RoleRepository;
import org.springframework.samples.oculusdb.repositories.UserRepository;
import org.springframework.samples.oculusdb.sponsor.Sponsor;
import org.springframework.samples.oculusdb.sponsor.Sponsorship;

import javax.transaction.Transactional;
import java.util.List;

public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Transactional
	public User userById(final int id) {
		return this.userRepository.findById(id).orElse(null);
	}

	@org.springframework.transaction.annotation.Transactional
	public Iterable<User> findAll() {
		return this.userRepository.findAll();
	}

	@Transactional
	public User userByUsername(String username) {
		return this.userRepository.findByUsername(username);
	}

	@Transactional
	public void saveUser(User user) {
		this.userRepository.save(user);
	}

	@Transactional
	public boolean isAdmin(User user) {
		return user.getRoles().stream().filter(o -> o.getName().equals("ADMIN")).findFirst().isPresent();
	}

	public boolean isSponsor(User user) {
		return user.getRoles().stream().filter(o -> o.getName().equals("SPONSOR")).findFirst().isPresent();
	}

	public List<Sponsorship> sponsorshipsOfUser(User user){
		return userRepository.sponoshorShipOfUser(user);
	}

	public void setSponsorRole(String username) {
		// Check if user already contain sponsor role
		User user = this.userByUsername(username);
		if (!user.getRoles().stream().filter(o -> o.getName().equals("SPONSOR")).findFirst().isPresent()) {
			Role sponsorRole = roleRepository.findRoleByName("SPONSOR");
			user.getRoles().add(sponsorRole);
			this.userRepository.save(user);
		}
		else {
			throw new UnsupportedOperationException("The user already has this role");
		}
	}

}
