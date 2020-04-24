
package org.springframework.samples.oculusdb.sponsor;

import org.springframework.samples.oculusdb.model.Actor;
import org.springframework.samples.oculusdb.model.CreditCard;
import org.springframework.samples.oculusdb.model.User;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Collection;

@Entity
@Table(name = "sponsors")
public class Sponsor extends Actor {

	@OneToMany(mappedBy = "sponsor")
	private Collection<Sponsorship> sponsorships;

	@OneToOne
	private CreditCard creditCard;

	@Column(name = "premium")
	private boolean premium;

	public Collection<Sponsorship> getSponsorships() {
		return sponsorships;
	}

	public void setSponsorships(Collection<Sponsorship> sponsorships) {
		this.sponsorships = sponsorships;
	}

	public CreditCard getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(CreditCard creditCard) {
		this.creditCard = creditCard;
	}

	@Override
	public String toString() {
		return "Sponsor{" + "sponsorships=" + sponsorships + ", creditCard=" + creditCard + '}';
	}

	public boolean isPremium() {
		return premium;
	}

	public void setPremium(boolean premium) {
		this.premium = premium;
	}

}
