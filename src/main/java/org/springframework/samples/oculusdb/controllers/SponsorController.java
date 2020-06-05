package org.springframework.samples.oculusdb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.oculusdb.model.User;
import org.springframework.samples.oculusdb.services.SecurityServiceImpl;
import org.springframework.samples.oculusdb.services.UserServiceImpl;
import org.springframework.samples.oculusdb.validator.UserValidator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/sponsor")
public class SponsorController {

	@Autowired
	private UserServiceImpl userServiceImpl;

	@Autowired
	private SecurityServiceImpl securityServiceImpl;

	@Autowired
	private UserValidator userValidator;

	@GetMapping("/registration")
	public String registration(ModelMap model) {
		model.addAttribute("userForm", new User());

		return "sponsor/SponsorRegistration";
	}

	@PostMapping("/registration")
	public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
		userValidator.validate(userForm, bindingResult);

		if (bindingResult.hasErrors()) {
			return "security/registration";
		}

		userServiceImpl.saveSponsor(userForm);

		securityServiceImpl.autoLogin(userForm.getUsername(), userForm.getGetPasswordConfirm());

		return "welcome";
	}

	@GetMapping("/login")
	public String login(ModelMap model, String error, String logout) {
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
		return "redirect:/login?logout";
	}

}
