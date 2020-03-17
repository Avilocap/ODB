
package org.springframework.samples.oculusdb.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.oculusdb.repositories.CreditCardRepository;

public class CreditCardService {

	@Autowired
	private CreditCardRepository creditCardRepository;


	@Transactional
	public int creditCardCount() {
		return (int) this.creditCardRepository.count();
	}
}