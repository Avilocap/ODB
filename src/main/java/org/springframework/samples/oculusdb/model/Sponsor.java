
package org.springframework.samples.oculusdb.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "sponsors")
public class Sponsor extends Actor {

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "sponsor")
	private Sponsorship	sponsorship;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "sponsor")
	private CreditCard	creditCard;


	public Sponsorship getSponsorship() {
		return this.sponsorship;
	}

	public void setSponsorship(final Sponsorship sponsorship) {
		this.sponsorship = sponsorship;
	}

	public CreditCard getCreditCard() {
		return this.creditCard;
	}

	public void setCreditCard(final CreditCard creditCard) {
		this.creditCard = creditCard;
	}

	@Override
	public String toString() {
		return "Sponsor [sponsorship=" + this.sponsorship + ", creditCard=" + this.creditCard + "]";
	}

}
