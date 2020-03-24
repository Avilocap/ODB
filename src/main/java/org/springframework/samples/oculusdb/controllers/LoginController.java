
package org.springframework.samples.oculusdb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.oculusdb.services.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;


	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/?username=")
	public ModelAndView getUser(@RequestParam final String nick) {
		ModelAndView vista = new ModelAndView("login");
		UserDetails user = this.userService.loadUserByUsername(nick);
		vista.addObject("user", user);
		vista.setViewName("welcome");
		return vista;
	}
}
