package org.springframework.samples.oculusdb.repositories;

import org.springframework.data.repository.CrudRepository;

import org.springframework.samples.oculusdb.model.CreditCard;

public interface CreditCardRepository extends CrudRepository<CreditCard, Integer> {

}
