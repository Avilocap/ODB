
package org.springframework.samples.oculusdb.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.oculusdb.repositories.CreditCardRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CreditCardService {

   @Autowired
   private CreditCardRepository creditCardRepository;

   @Transactional
   public int creditCardCount() {
      return (int) this.creditCardRepository.count();
   }

}
