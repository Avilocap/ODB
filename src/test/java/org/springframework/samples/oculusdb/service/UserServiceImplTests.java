
package org.springframework.samples.oculusdb.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.samples.oculusdb.model.Role;
import org.springframework.samples.oculusdb.model.User;
import org.springframework.samples.oculusdb.repositories.RoleRepository;
import org.springframework.samples.oculusdb.services.ReviewService;
import org.springframework.samples.oculusdb.services.UserServiceImpl;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class UserServiceImplTests {

	@Autowired
	private UserServiceImpl userServiceImpl;

	@Autowired
	private RoleRepository roleRepository;

	@Test
	public void saveUserPositiveCase1() {
		String username = "Prueba";
		User user = new User();
		user.setUsername(username);
		user.setPassword("prueba");
		user.setName("Nombre");
		user.setSurname("Apellidos");
		user.setEmail("Correo@correo.com");
		userServiceImpl.save(user);
		Assertions.assertNotNull(userServiceImpl.findByUsername(username));
	}

	@Test
	public void saveUserPositiveCase2() {
		String username = "Prueba2";
		User user = new User();
		user.setUsername(username);
		user.setPassword("prueba2");
		user.setName("Nombre2");
		user.setSurname("Apellidos2");
		user.setEmail("Correo2@correo2.com");
		userServiceImpl.save(user);
		Assertions.assertNotNull(userServiceImpl.findByUsername(username));

	}

	@Test
	public void saveUserPositiveCase3() {
		String username = "Prueba3";
		User user = new User();
		user.setUsername(username);
		user.setPassword("prueba3");
		user.setName("Nombre3");
		user.setSurname("Apellidos3");
		user.setEmail("Correo3@correo3.com");
		userServiceImpl.save(user);
		Assertions.assertNotNull(userServiceImpl.findByUsername(username));
	}

	@Test
	public void saveUserNegativeCaseWrongUsername() {
		String username = "";
		User user = new User();
		user.setUsername(username);
		user.setPassword("prueba3");
		user.setName("Nombre3");
		user.setSurname("Apellidos3");
		user.setEmail("Correo3@correo3.com");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			userServiceImpl.save(user);
		});
	}

	@Test
	public void saveUserNegativeCaseWrongPassword() {
		String username = "Prueba3";
		User user = new User();
		user.setUsername(username);
		user.setPassword("");
		user.setName("Nombre3");
		user.setSurname("Apellidos3");
		user.setEmail("Correo3@correo3.com");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			userServiceImpl.save(user);
		});

	}

	@Test
	public void saveUserNegativeCaseWrongName() {
		String username = "Prueba2";
		User user = new User();
		user.setUsername(username);
		user.setPassword("prueba2");
		user.setName("");
		user.setSurname("Apellidos2");
		user.setEmail("Correo2@correo2.com");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			userServiceImpl.save(user);
		});
	}

	@Test
	public void saveUserNegativeCaseWrongName2() {
		String username = "Prueba2";
		User user = new User();
		user.setUsername(username);
		user.setPassword("prueba2");
		user.setName("");
		user.setSurname("");
		user.setEmail("Correo2@correo2.com");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			userServiceImpl.save(user);
		});
	}

	@Test
	public void saveUserNegativeCaseWrongEmail() {
		String username = "Prueba2";
		User user = new User();
		user.setUsername(username);
		user.setPassword("prueba2");
		user.setName("Nombre2");
		user.setSurname("Apellidos2");
		user.setEmail("");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			userServiceImpl.save(user);
		});
	}

	@Test
	public void saveUserCheckRole() {
		String username = "Prueba";
		User user = new User();
		user.setUsername(username);
		user.setPassword("prueba");
		user.setName("Nombre");
		user.setSurname("Apellidos");
		user.setEmail("Correo@correo.com");
		userServiceImpl.save(user);
		User savedUser = userServiceImpl.findByUsername(username);
		Role userRole = roleRepository.findRoleByName("USER");
		Assertions.assertTrue(savedUser.getRoles().contains(userRole));
	}

}
