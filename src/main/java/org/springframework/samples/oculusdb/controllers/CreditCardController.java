
package org.springframework.samples.oculusdb.controllers;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.oculusdb.model.Application;
import org.springframework.samples.oculusdb.services.CreditCardService;
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

	@GetMapping("/new")
	public String loadCreditCardForm() {
		String vista = "creditCard/creditCardForm.html";
		return vista;
	}

	@RequestMapping("/pay")
	public String processPayment(@RequestParam String number, @RequestParam int expY, @RequestParam int expM,
			@RequestParam int cvv) {
		String vista = "";
		if (this.creditCardService.checkCreditCard(number, expY, expM, cvv)) {
			vista = "creditCard/pagoRealizado";
		}
		else {
			vista = "creditCard/PagoErroneo";
		}
		return vista;
	}

}
