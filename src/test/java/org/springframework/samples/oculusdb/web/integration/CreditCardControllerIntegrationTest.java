package org.springframework.samples.oculusdb.web.integration;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.samples.oculusdb.controllers.CreditCardController;
import org.springframework.samples.oculusdb.services.CreditCardService;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CreditCardControllerIntegrationTest {

	@Autowired
	private CreditCardService creditCardService;

	@Autowired
	private CreditCardController creditCardController;

	@WithMockUser("adri")
	@Test
	void testInitCreditCardFormSuccess() throws Exception {
		String view = creditCardController.loadCreditCardForm();
		Assertions.assertEquals(view, "creditCard/creditCardForm.html");
	}

	@WithMockUser("adri")
	@Test
	void testInitCreditCardFormHasErrors() throws Exception {

		String view = creditCardController.loadCreditCardForm();
		Assertions.assertNotEquals(view, "creditCard/creditCardFormm.html");
	}

	@WithMockUser("testuser")
	@Test
	void testInitCreditCardFormPremiumSuccess() throws Exception {

		String view = creditCardController.loadCreditCardForm();
		System.out.println(view);
		Assertions.assertEquals(view, "creditCard/yaPremium.html");
	}

	@WithMockUser("testuser")
	@Test
	void testInitCreditCardFormPremiumHasErrors() throws Exception {

		String view = creditCardController.loadCreditCardForm();
		Assertions.assertNotEquals(view, "creditCard/yaPremiumm.html");
	}

	@WithMockUser("testuser")
	@Test
	void testPaySuccess() throws Exception {
		String number = "12300";
		int expY = 2023;
		int expM = 10;
		int cvv = 345;
		String view = creditCardController.processPayment(number, expY, expM, cvv);
		Assertions.assertEquals(view, "creditCard/PagoErroneo");
	}

	@WithMockUser("testuser")
	@Test
	void payHasErrors1() throws Exception {
		String number = "123000";
		int expY = 2018;
		int expM = 10;
		int cvv = 345;
		String view = creditCardController.processPayment(number, expY, expM, cvv);
		Assertions.assertEquals(view, "creditCard/PagoErroneo");
	}

	@WithMockUser("testuser")
	@Test
	void testPayHasErrors2() throws Exception {
		String number = "338976";
		int expY = 2023;
		int expM = 123;
		int cvv = 345;
		String view = creditCardController.processPayment(number, expY, expM, cvv);
		Assertions.assertEquals(view, "creditCard/PagoErroneo");
	}

	@WithMockUser("testuser")
	@Test
	void testPayHasErrors3() throws Exception {
		String number = "338976";
		int expY = 2023;
		int expM = 10;
		int cvv = 1000;
		String view = creditCardController.processPayment(number, expY, expM, cvv);
		Assertions.assertEquals(view, "creditCard/PagoErroneo");
	}

	@WithMockUser("testuser")
	@Test
	void testPayHasErrors4() throws Exception {
		String number = "338976";
		int expY = 2023;
		int expM = 10;
		int cvv = 1000;
		String view = creditCardController.processPayment(number, expY, expM, cvv);
		Assertions.assertNotEquals(view, "creditCard/PagoErroneoo");
	}

}
