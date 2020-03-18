package org.springframework.samples.oculusdb.sponsor;

import com.stripe.Stripe;
import com.stripe.model.Charge;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class StripeService {

   @Value("${stripe.keys.secret}")
   private String API_SECRET_KEY;

   public StripeService() {
   }

   public String createCharge(String email, String token, int amount) {
      String id = null;
      try {
         Stripe.apiKey = API_SECRET_KEY;
         Map<String, Object> chargeParams = new HashMap<>();
         chargeParams.put("amount", amount);
         chargeParams.put("currency", "usd");
         chargeParams.put("description", "Charge for " + email);
         chargeParams.put("source", token); // ^ obtained with Stripe.js

         // create a charge
         Charge charge = Charge.create(chargeParams);
         id = charge.getId();
      } catch (Exception ex) {
         ex.printStackTrace();
      }
      return id;
   }

}
