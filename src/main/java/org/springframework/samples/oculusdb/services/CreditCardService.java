
package org.springframework.samples.oculusdb.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.oculusdb.repositories.CreditCardRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.transaction.Transactional;
import java.util.Date;

@SuppressWarnings("deprecation")
@Service
public class CreditCardService {

	@Autowired
	private CreditCardRepository creditCardRepository;

	@Transactional
	public int creditCardCount() {
		return (int) this.creditCardRepository.count();
	}

	@Transactional
	public boolean checkCreditCard(String number, int expirationYear, int expirationMonth, int cvv) {
		boolean res;

		Assert.notNull(number);
		Assert.isTrue(expirationMonth >= 1);
		Assert.isTrue(cvv >= 1);

		int yearAct0 = (((new Date(System.currentTimeMillis())).getYear()));
		String year = "20" + Integer.toString(yearAct0).substring(1);
		int yearAct = new Integer(year);
		int monthAct = new Date(System.currentTimeMillis()).getMonth();
		if (expirationYear == yearAct) {
			res = true;
		}
		else
			res = expirationYear >= yearAct;
		return res;

	}

}
