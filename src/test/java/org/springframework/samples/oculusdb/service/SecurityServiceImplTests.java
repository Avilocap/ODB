
package org.springframework.samples.oculusdb.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.samples.oculusdb.model.Application;
import org.springframework.samples.oculusdb.model.User;
import org.springframework.samples.oculusdb.services.ReviewService;
import org.springframework.samples.oculusdb.services.SecurityServiceImpl;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

@SpringBootTest
@Transactional
public class SecurityServiceImplTests {

	@Autowired
	private SecurityServiceImpl securityServiceImpl;

	@Test
	public void autologinPositiveCase1() {
		securityServiceImpl.autoLogin("testuser", "testuser");
	}

	@Test
	public void autologinPositiveCase2() {
		securityServiceImpl.autoLogin("manu", "testuser");
	}

	@Test
	public void autologinNegativeWrongUsernameCase1() {
		Assertions.assertThrows(UsernameNotFoundException.class, () -> {
			securityServiceImpl.autoLogin("kkaak", "testuser");
		});
	}

	@Test
	public void autologinNegativeWrongUsernameCase2() {
		Assertions.assertThrows(UsernameNotFoundException.class, () -> {
			securityServiceImpl.autoLogin("hgfd", "testuser");
		});

	}

	@Test
	public void autologinNegativeWrongPasswordCase1() {
		Assertions.assertThrows(BadCredentialsException.class, () -> {
			securityServiceImpl.autoLogin("manu", "ssss");
		});
	}

	@Test
	public void autologinNegativeWrongPasswordCase2() {
		Assertions.assertThrows(BadCredentialsException.class, () -> {
			securityServiceImpl.autoLogin("testuser", "ghds");
		});
	}

	@Test
	public void autologinNegativeEmptyUsername() {
		Assertions.assertThrows(UsernameNotFoundException.class, () -> {
			securityServiceImpl.autoLogin("", "testuser");
		});
	}

	@Test
	public void autologinNegativeEmptyPassword() {
		Assertions.assertThrows(BadCredentialsException.class, () -> {
			securityServiceImpl.autoLogin("testuser", "");
		});
	}

}
