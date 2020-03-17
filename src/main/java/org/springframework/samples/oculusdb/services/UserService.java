
package org.springframework.samples.oculusdb.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.oculusdb.model.User;
import org.springframework.samples.oculusdb.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;


	@Transactional
	public User userById(final int id) {
		return this.userRepository.findById(id).orElse(null);
	}

}
