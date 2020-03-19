
package org.springframework.samples.oculusdb.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.samples.oculusdb.model.User;
import org.springframework.samples.oculusdb.services.UserService;

@SpringBootTest
public class UserServiceTests {

	@Autowired
	private UserService userService;


	@Test
	public void testId() {
		int id = 0;
		User s = this.userService.userById(id);
		User s2 = this.userService.userById(id);
		Assertions.assertEquals(s, s2);
	}

}
