package org.springframework.samples.oculusdb.sponsor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PaymentController {

	private String API_PUBLIC_KEY = "pk_test_79qx9zkhTiOL8EV9xE789MSW00CgoOivla";

	private StripeService stripeService;

	@GetMapping("/charge")
	public String chargePage(Model model) {
		model.addAttribute("stripePublicKey", API_PUBLIC_KEY);
		return "charge";
	}
	//
	// @PostMapping("/create-charge")
	// public @ResponseBody void createCharge(String email, String token) {
	// // create charge
	// String chargeId = stripeService.createCharge(email, token, 999); // $9.99 USD
	// }
	// https://attacomsian.com/blog/stripe-integration-with-spring-boot#
	// https://www.baeldung.com/java-stripe-api

}
