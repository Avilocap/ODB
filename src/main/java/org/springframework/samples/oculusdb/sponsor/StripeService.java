package org.springframework.samples.oculusdb.sponsor;

import org.springframework.stereotype.Service;

@Service
public class StripeService {

	private String API_SECRET_KEY = "sk_test_hqZBArkbIsAJxd8HXQ4hHZdv00XwUDXZah";

	// public StripeService() {
	// }
	//
	// public String createCharge(String email, String token, int amount) {
	// String id = null;
	// try {
	// Stripe.apiKey = API_SECRET_KEY;
	// Map<String, Object> chargeParams = new HashMap<>();
	// chargeParams.put("amount", amount);
	// chargeParams.put("currency", "usd");
	// chargeParams.put("description", "Charge for " + email);
	// chargeParams.put("source", token); // ^ obtained with Stripe.js
	//
	// // create a charge
	// Charge charge = Charge.create(chargeParams);
	// id = charge.getId();
	// }
	// catch (Exception ex) {
	// ex.printStackTrace();
	// }
	// return id;
	// }

	/**
	 * STRIPE_PUBLIC_KEY=pk_test_79qx9zkhTiOL8EV9xE789MSW00CgoOivla
	 * STRIPE_SECRET_KEY=sk_test_hqZBArkbIsAJxd8HXQ4hHZdv00XwUDXZah
	 */

}
