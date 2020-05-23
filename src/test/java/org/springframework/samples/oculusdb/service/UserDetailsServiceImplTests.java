
package org.springframework.samples.oculusdb.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.samples.oculusdb.services.ReviewService;
import org.springframework.samples.oculusdb.services.UserDetailsServiceImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class UserDetailsServiceImplTests {

	@Autowired
	private UserDetailsServiceImpl userDetailsService;

	@Test
	public void loadByUsernamePositiveCase1() {
		String testusername = "testuser";
		UserDetails userDetails = userDetailsService.loadUserByUsername(testusername);
		Assertions.assertTrue(userDetails.getUsername().equals(testusername));
	}

	@Test
	public void loadByUsernamePositiveCase2() {
		String testusername = "manu";
		UserDetails userDetails = userDetailsService.loadUserByUsername(testusername);
		Assertions.assertTrue(userDetails.getUsername().equals(testusername));
	}

	@Test
	public void loadByUsernameNegativeWrongUsername() {
		Assertions.assertThrows(UsernameNotFoundException.class, () -> {
			String testusername = "erwdf";
			userDetailsService.loadUserByUsername(testusername);
		});
	}

	@Test
	public void loadByUsernameNegativeEmptyUsername() {
		Assertions.assertThrows(UsernameNotFoundException.class, () -> {
			String testusername = "erwdf";
			userDetailsService.loadUserByUsername(testusername);
		});
	}

}
