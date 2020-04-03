
package org.springframework.samples.oculusdb.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.oculusdb.model.User;
import org.springframework.samples.oculusdb.repositories.UserRepository;

import javax.transaction.Transactional;

public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Transactional
	public User userById(final int id) {
		return this.userRepository.findById(id).orElse(null);
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

}
