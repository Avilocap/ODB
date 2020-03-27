package org.springframework.samples.oculusdb.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.samples.oculusdb.model.Role;
import org.springframework.samples.oculusdb.model.User;
import org.springframework.samples.oculusdb.repositories.RoleRepository;
import org.springframework.samples.oculusdb.repositories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
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
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		Random random = new Random();
		user.setId(random.nextInt());
		Role userRole = roleRepository.findRoleByName("USER");
		Set<Role> userRoles = new HashSet<Role>();
		userRoles.add(userRole);
		user.setRoles(userRoles);
		userRepository.save(user);
	}

	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

}
