
package org.springframework.samples.oculusdb.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.oculusdb.model.User;
import org.springframework.samples.oculusdb.model.UserAccount;
import org.springframework.samples.oculusdb.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;


	@Transactional
	public User userById(final int id) {
		return this.userRepository.findById(id).orElse(null);
	}

	@Override
	public UserDetails loadUserByUsername(final String nick) throws UsernameNotFoundException {

		User user = this.userRepository.findByNick(nick).orElseThrow(() -> new UsernameNotFoundException("No existe usuario"));

		String authority = user.getUserAccount().getAuthority();

		UserDetails user2 = (UserDetails) new UserAccount(user.getUserAccount().getNick(), user.getUserAccount().getPassword(), user.getUserAccount().getAuthority());

		return user2;

	}

}
