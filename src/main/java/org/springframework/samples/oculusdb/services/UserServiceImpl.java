package org.springframework.samples.oculusdb.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.oculusdb.model.Role;
import org.springframework.samples.oculusdb.model.User;
import org.springframework.samples.oculusdb.repositories.RoleRepository;
import org.springframework.samples.oculusdb.repositories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
public class UserServiceImpl extends UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public void save(User user) {

		if (user.getUsername().equals("") || user.getPassword().equals("") || user.getName().equals("")
				|| user.getEmail().equals("")) {
			throw new IllegalArgumentException("Username should not be empty");
		}
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		Random random = new Random();
		user.setId(random.nextInt());
		Role userRole = roleRepository.findRoleByName("USER");
		Set<Role> userRoles = new HashSet<>();
		userRoles.add(userRole);
		user.setRoles(userRoles);
		user.setActive(true);
		userRepository.save(user);
	}

	public void saveSponsor(User user) {
		if (user.getUsername().equals("") || user.getPassword().equals("") || user.getName().equals("")
				|| user.getSurname().equals("") || user.getEmail().equals("")) {
			throw new IllegalArgumentException("Username should not be empty");
		}
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		Random random = new Random();
		user.setId(random.nextInt());
		Role userRole = roleRepository.findRoleByName("USER");
		Role sponsorRole = roleRepository.findRoleByName("SPONSOR");
		Set<Role> userRoles = new HashSet<>();
		userRoles.add(userRole);
		userRoles.add(sponsorRole);
		user.setRoles(userRoles);
		user.setActive(true);
		userRepository.save(user);
	}

	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

}
