
package org.springframework.samples.oculusdb.model;

public class Sponsor extends Actor {

	private Sponsorship	sponsorship;
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
