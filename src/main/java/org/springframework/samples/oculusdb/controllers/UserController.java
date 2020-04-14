package org.springframework.samples.oculusdb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.oculusdb.model.User;
import org.springframework.samples.oculusdb.services.SecurityService;
import org.springframework.samples.oculusdb.services.SecurityServiceImpl;
import org.springframework.samples.oculusdb.services.UserService;
import org.springframework.samples.oculusdb.services.UserServiceImpl;
import org.springframework.samples.oculusdb.validator.UserValidator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import javax.naming.OperationNotSupportedException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class UserController {

	@Autowired
	private UserServiceImpl userServiceImpl;

	@Autowired
	private UserService userService;

	@Autowired
	private SecurityServiceImpl securityServiceImpl;

	@Autowired
	private UserValidator userValidator;

	@GetMapping("/registration")
	public String registration(Model model) {
		model.addAttribute("userForm", new User());

		return "security/registration";
	}

	@PostMapping("/registration")
	public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
		userValidator.validate(userForm, bindingResult);

		if (bindingResult.hasErrors()) {
			return "security/registration";
		}

		userServiceImpl.save(userForm);

		securityServiceImpl.autoLogin(userForm.getUsername(), userForm.getGetPasswordConfirm());

		return "welcome";
	}

	@GetMapping("/login")
	public String login(Model model, String error, String logout) {
		if (error != null)
			model.addAttribute("error", "Your username and password is invalid.");

		if (logout != null)
			model.addAttribute("message", "You have been logged out successfully.");

		return "security/login";
	}

	@PostMapping("/login")
	public String performLogin(@RequestParam String username, @RequestParam String password) {
		securityServiceImpl.autoLogin(username, password);
		return "redirect:/";
	}

	@GetMapping("/logout")
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/login?logout";// You can redirect wherever you want, but
										// generally it's a good practice to show login
										// screen again.
	}

	@GetMapping("/users/list")
	public String listUsers(final ModelMap modelMap) {
		String vista;
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		User user = this.userService.userByUsername(currentPrincipalName);
		if (userService.isAdmin(user)) {
			vista = "users/list";
			Iterable<User> users = userService.findAll();
			modelMap.addAttribute("users", users);
		}
		else {
			vista = "error";
		}
		return vista;
	}

	@GetMapping("/users/setSponsor/{username}")
	public String setSponsor(@PathVariable("username") String username) {
		String vista;
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		User user = this.userService.userByUsername(currentPrincipalName);
		if (userService.isAdmin(user)) {
			userService.setSponsorRole(username);
			vista = "users/sponsorSet";
		}
		else {
			vista = "error";
		}
		return vista;
	}
	// @GetMapping({ "/", "/welcome" })
	// public String welcome(Model model) {
	// return "welcome";
	// }

}
