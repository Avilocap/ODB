
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

import javax.xml.crypto.Data;
import java.util.*;

@SpringBootTest
@Transactional
@Deprecated
public class CreditCardServiceTests {

	@Autowired
	private CreditCardService creditCardService;

	int randomCreditCardNumber = (int) 5489018195186573L;

	@Test
	public void createCreditCardOk0() {
		CreditCard creditCard = new CreditCard();
		creditCard.setCVV(123);
		creditCard.setExpirationMonth(12);
		creditCard.setExpirationYear(2022);
		creditCard.setNumber(randomCreditCardNumber);
		creditCard.setHolderName("Pepito el de los palotes");
		boolean res = this.creditCardService.checkCreditCard(creditCard.getNumber().toString(),
				creditCard.getExpirationYear(), creditCard.getExpirationMonth(), creditCard.getCVV());
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
		boolean res = this.creditCardService.checkCreditCard(creditCard.getNumber().toString(),
				creditCard.getExpirationYear(), creditCard.getExpirationMonth(), creditCard.getCVV());
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

}
