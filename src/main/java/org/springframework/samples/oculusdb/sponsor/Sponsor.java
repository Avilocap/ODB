
package org.springframework.samples.oculusdb.sponsor;

import org.springframework.samples.oculusdb.model.Actor;
import org.springframework.samples.oculusdb.model.CreditCard;
import javax.persistence.*;

@Entity
@Table(name = "sponsors")
public class Sponsor extends Actor {

	@OneToOne
	private CreditCard creditCard;

	public CreditCard getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(CreditCard creditCard) {
		this.creditCard = creditCard;
	}

	@Override
	public String toString() {
		return "Sponsor{" + "sponsorships=" + ", creditCard=" + creditCard + '}';
	}

}
