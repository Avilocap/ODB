
package org.springframework.samples.oculusdb.service;

import java.security.Provider.Service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.samples.oculusdb.model.User;
import org.springframework.samples.oculusdb.services.UserService;

@DataJpaTest(includeFilters = @ComponentScan.Filter(Service.class))
public class UserServiceTests {

	@Autowired
	private UserService userService;


	@Test
	public void testCount() {
		int id = 0;
		User s = this.userService.userById(id);
		User s2 = this.userService.userById(id);
		Assertions.assertEquals(s, s2);
	}

}
