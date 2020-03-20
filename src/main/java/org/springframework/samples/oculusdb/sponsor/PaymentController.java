package org.springframework.samples.oculusdb.sponsor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PaymentController {

	@Value("${stripe.keys.public}")
	private String API_PUBLIC_KEY;

	private StripeService stripeService;

	public PaymentController(StripeService stripeService) {
		this.stripeService = stripeService;
	}

	@GetMapping("/")
	public String homepage() {
		return "homepage";
	}

	@GetMapping("/charge")
	public String chargePage(Model model) {
		model.addAttribute("stripePublicKey", API_PUBLIC_KEY);
		return "charge";
	}

	@PostMapping("/create-charge")
	public @ResponseBody
	void createCharge(String email, String token) {
		// create charge
		String chargeId = stripeService.createCharge(email, token, 999); // $9.99 USD
	}
	//https://attacomsian.com/blog/stripe-integration-with-spring-boot#
	//https://www.baeldung.com/java-stripe-api

}
