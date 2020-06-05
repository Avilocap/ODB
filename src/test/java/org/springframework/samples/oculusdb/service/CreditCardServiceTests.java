
package org.springframework.samples.oculusdb.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.samples.oculusdb.model.CreditCard;
import org.springframework.samples.oculusdb.model.User;
import org.springframework.samples.oculusdb.services.CreditCardService;
import org.springframework.samples.oculusdb.services.UserService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import java.util.*;

@SpringBootTest
@Transactional
@SuppressWarnings("deprecation")
public class CreditCardServiceTests {

	@Autowired
	private CreditCardService creditCardService;

	@Autowired
	private UserService userService;

	int randomCreditCardNumber = (int) 4137810659147011L;

	@Test
	public void createCreditCardOk0() {
		CreditCard creditCard = new CreditCard();
		creditCard.setCVV(123);
		creditCard.setExpirationMonth(12);
		creditCard.setExpirationYear(2022);
		creditCard.setNumber(randomCreditCardNumber);
		creditCard.setHolderName("Pepito el de los palotes");
		boolean res = this.creditCardService.checkCreditCard("4137810659147011", creditCard.getExpirationYear(),
				creditCard.getExpirationMonth(), creditCard.getCVV());
		Assert.isTrue(res);
	}

	@Test
	public void createCreditCardOk1() {
		CreditCard creditCard = new CreditCard();
		creditCard.setCVV(452);
		creditCard.setExpirationMonth(4);
		creditCard.setExpirationYear(2050);
		creditCard.setNumber(randomCreditCardNumber + 1);
		creditCard.setHolderName("Pepito el de los palotes");
		boolean res = this.creditCardService.checkCreditCard("8137810659147046", creditCard.getExpirationYear(),
				creditCard.getExpirationMonth(), creditCard.getCVV());
		Assert.isTrue(res);
	}

	@Test
	public void createCreditCardBadYear() {
		CreditCard creditCard = new CreditCard();
		creditCard.setCVV(123);
		creditCard.setExpirationMonth(12);
		creditCard.setExpirationYear(1976);
		creditCard.setNumber(randomCreditCardNumber + 2);
		creditCard.setHolderName("Pepito el de los palotes");
		boolean res = this.creditCardService.checkCreditCard(creditCard.getNumber().toString(),
				creditCard.getExpirationYear(), creditCard.getExpirationMonth(), creditCard.getCVV());
		Assert.isTrue(!res);
	}

	@Test
	public void createCreditCardBadYearPastToActual() {
		CreditCard creditCard = new CreditCard();
		creditCard.setCVV(123);
		creditCard.setExpirationMonth(12);
		creditCard.setExpirationYear(new Date(System.currentTimeMillis() - 100).getYear() - 5);
		creditCard.setNumber(randomCreditCardNumber + 2);
		creditCard.setHolderName("Pepito el de los palotes");
		boolean res = this.creditCardService.checkCreditCard(creditCard.getNumber().toString(),
				creditCard.getExpirationYear(), creditCard.getExpirationMonth(), creditCard.getCVV());
		Assert.isTrue(!res);
	}

	@Test
	public void createCreditCardBadMonth() {
		CreditCard creditCard = new CreditCard();
		creditCard.setCVV(123);
		creditCard.setExpirationMonth(new Date(System.currentTimeMillis() - 100).getMonth() + 33);
		creditCard.setExpirationYear(new Date(System.currentTimeMillis() - 100).getYear());
		creditCard.setNumber(randomCreditCardNumber + 3);
		creditCard.setHolderName("Pepito el de los palotes");
		boolean res = this.creditCardService.checkCreditCard(creditCard.getNumber().toString(),
				creditCard.getExpirationYear(), creditCard.getExpirationMonth(), creditCard.getCVV());
		Assert.isTrue(!res);
	}

	@Test
	public void createCreditCardBadMonthCloseToActual() {
		CreditCard creditCard = new CreditCard();
		creditCard.setCVV(123);
		creditCard.setExpirationMonth(new Date(System.currentTimeMillis() - 100).getMonth() - 1);
		creditCard.setExpirationYear(new Date(System.currentTimeMillis() - 100).getYear());
		creditCard.setNumber(randomCreditCardNumber + 3);
		creditCard.setHolderName("Pepito el de los palotes");
		boolean res = this.creditCardService.checkCreditCard(creditCard.getNumber().toString(),
				creditCard.getExpirationYear(), creditCard.getExpirationMonth(), creditCard.getCVV());
		Assert.isTrue(!res);
	}

	@Test
	public void createCreditCardAboutToExpire() {
		CreditCard creditCard = new CreditCard();
		creditCard.setCVV(123);
		creditCard.setExpirationMonth(new Date(System.currentTimeMillis() - 100).getMonth());
		creditCard.setExpirationYear(new Date(System.currentTimeMillis() - 100).getYear());
		creditCard.setNumber(randomCreditCardNumber + 4);
		creditCard.setHolderName("Pepito el de los palotes");
		boolean res = this.creditCardService.checkCreditCard(creditCard.getNumber().toString(),
				creditCard.getExpirationYear(), creditCard.getExpirationMonth(), creditCard.getCVV());
		Assert.isTrue(!res);
	}

	@Test
	public void checkCreditCardPositiveCase1() {
		String number = "4137810659147011";
		int expirationYear = 2021;
		int expirationMonth = 12;
		int cvv = 345;
		Assertions.assertTrue(creditCardService.checkCreditCard(number, expirationYear, expirationMonth, cvv));
	}

	@Test
	public void checkCreditCardPositiveCase2() {
		String number = "8137810659147046";
		int expirationYear = 2022;
		int expirationMonth = 06;
		int cvv = 545;
		Assertions.assertTrue(creditCardService.checkCreditCard(number, expirationYear, expirationMonth, cvv));
	}

	@Test
	public void checkCreditCardBadNumber() {
		String number = "8137810";
		int expirationYear = 2022;
		int expirationMonth = 06;
		int cvv = 545;
		Assertions.assertFalse(creditCardService.checkCreditCard(number, expirationYear, expirationMonth, cvv));
	}

	@Test
	public void checkCreditCardEmptyNumber() {
		String number = "";
		int expirationYear = 2022;
		int expirationMonth = 06;
		int cvv = 545;
		Assertions.assertFalse(creditCardService.checkCreditCard(number, expirationYear, expirationMonth, cvv));
	}

	@Test
	public void checkCreditCardNullNumber() {
		String number = null;
		int expirationYear = 2022;
		int expirationMonth = 06;
		int cvv = 545;
		Assertions.assertFalse(creditCardService.checkCreditCard(number, expirationYear, expirationMonth, cvv));
	}

	@Test
	public void checkCreditCardBadYear() {
		String number = "8137810659147046";
		int expirationYear = 1998;
		int expirationMonth = 06;
		int cvv = 545;
		Assertions.assertFalse(creditCardService.checkCreditCard(number, expirationYear, expirationMonth, cvv));
	}

	@Test
	public void checkCreditCardBadMonth() {
		String number = "8137810659147046";
		int expirationYear = 2022;
		int expirationMonth = 54;
		int cvv = 545;
		Assertions.assertFalse(creditCardService.checkCreditCard(number, expirationYear, expirationMonth, cvv));
	}

	@Test
	public void checkCreditCardBadCvv() {
		String number = "8137810659147046";
		int expirationYear = 2022;
		int expirationMonth = 54;
		int cvv = 444444;
		Assertions.assertFalse(creditCardService.checkCreditCard(number, expirationYear, expirationMonth, cvv));
	}

	@Test
	public void paymentProcessing() {
		List<User> users = new ArrayList<>((List<? extends User>) this.userService.findAll());
		User userAux = users.get(4);
		String currentPrincipalName = userAux.getName();
		User currentUser = userService.userByUsername(currentPrincipalName);
		boolean res;
		if (this.creditCardService.checkCreditCard("5489018195186573", 2028,
				new Date(System.currentTimeMillis() - 100).getMonth() + 6, 242)) {
			currentUser.setPremium(true);
			userService.saveUser(currentUser);
			res = true;
		}
		else {
			res = false;
		}
		Assert.isTrue(res);
	}

	@Test
	public void badPaymentProcessing0() {
		List<User> users = new ArrayList<>((List<? extends User>) this.userService.findAll());
		User userAux = users.get(4);
		String currentPrincipalName = userAux.getName();
		User currentUser = userService.userByUsername(currentPrincipalName);
		boolean res;
		if (this.creditCardService.checkCreditCard("5489018195186573",
				new Date(System.currentTimeMillis() - 100).getYear(),
				new Date(System.currentTimeMillis() - 100).getMonth() + 6, 242)) {
			currentUser.setPremium(true);
			userService.saveUser(currentUser);
			res = true;
		}
		else {
			res = false;
		}
		Assert.isTrue(!res);
	}

	@Test
	public void badPaymentProcessing1() {
		List<User> users = new ArrayList<>((List<? extends User>) this.userService.findAll());
		User userAux = users.get(4);
		String currentPrincipalName = userAux.getName();
		User currentUser = userService.userByUsername(currentPrincipalName);
		boolean res;
		if (this.creditCardService.checkCreditCard("", new Date(System.currentTimeMillis() - 100).getYear(),
				new Date(System.currentTimeMillis() - 100).getMonth() + 6, 242)) {
			currentUser.setPremium(true);
			userService.saveUser(currentUser);
			res = true;
		}
		else {
			res = false;
		}
		Assert.isTrue(!res);
	}

	@Test
	public void badPaymentProcessing2() {
		List<User> users = new ArrayList<>((List<? extends User>) this.userService.findAll());
		User userAux = users.get(4);
		String currentPrincipalName = userAux.getName();
		User currentUser = userService.userByUsername(currentPrincipalName);
		boolean res;
		if (this.creditCardService.checkCreditCard("5489018195186573",
				new Date(System.currentTimeMillis() - 100).getYear(),
				new Date(System.currentTimeMillis() - 100).getMonth(), 242)) {
			currentUser.setPremium(true);
			userService.saveUser(currentUser);
			res = true;
		}
		else {
			res = false;
		}
		Assert.isTrue(!res);
	}

	@Test
	public void badPaymentProcessing3() {
		List<User> users = new ArrayList<>((List<? extends User>) this.userService.findAll());
		User userAux = users.get(4);
		String currentPrincipalName = userAux.getName();
		User currentUser = userService.userByUsername(currentPrincipalName);
		boolean res;
		if (this.creditCardService.checkCreditCard("5489018195186573",
				new Date(System.currentTimeMillis() - 100).getYear() - 100,
				new Date(System.currentTimeMillis() - 100).getMonth() + 6, 242)) {
			currentUser.setPremium(true);
			userService.saveUser(currentUser);
			res = true;
		}
		else {
			res = false;
		}
		Assert.isTrue(!res);
	}

}
