
package org.springframework.samples.oculusdb.controllers;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.oculusdb.model.Application;
import org.springframework.samples.oculusdb.model.User;
import org.springframework.samples.oculusdb.services.CreditCardService;
import org.springframework.samples.oculusdb.services.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.io.IOException;
import java.util.Optional;

@Controller
@RequestMapping("/creditCard")
public class CreditCardController {

	@Autowired
	private CreditCardService creditCardService;

	@Autowired
	private UserService userService;

	@GetMapping("/new")
	public String loadCreditCardForm() {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		User currentUser = userService.userByUsername(currentPrincipalName);

		if (!currentUser.isPremium()) {
			String vista = "creditCard/creditCardForm.html";
			return vista;
		}
		else {
			String vista = "creditCard/yaPremium.html";
			return vista;
		}

	}

	@RequestMapping("/pay")
	public String processPayment(@RequestParam String number, @RequestParam int expY, @RequestParam int expM,
			@RequestParam int cvv) {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		User currentUser = userService.userByUsername(currentPrincipalName);

		String vista;
		if (this.creditCardService.checkCreditCard(number, expY, expM, cvv)) {
			currentUser.setPremium(true);
			userService.saveUser(currentUser);
			vista = "creditCard/pagoRealizado";
		}
		else {
			vista = "creditCard/PagoErroneo";
		}
		return vista;
	}

}
