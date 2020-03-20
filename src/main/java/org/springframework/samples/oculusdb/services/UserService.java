
package org.springframework.samples.oculusdb.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.oculusdb.model.User;
import org.springframework.samples.oculusdb.repositories.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserService {

   @Autowired
   private UserRepository userRepository;

   @Transactional
   public User userById(final int id) {
      return this.userRepository.findById(id).orElse(null);
	}

}
