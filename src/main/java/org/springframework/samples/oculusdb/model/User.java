
package org.springframework.samples.oculusdb.model;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.samples.oculusdb.sponsor.Sponsorship;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User extends Actor {

	@OneToMany(fetch = FetchType.EAGER)
	private List<Application> favorites;

	@Column(name = "premium")
	private boolean premium;

	@OneToMany
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Sponsorship> sponsorships;

	public List<Application> getFavorites() {
		return favorites;
	}

	public void setFavorites(List<Application> favorites) {
		this.favorites = favorites;
	}

	public User() {
	}

	public List<Sponsorship> getSponsorships() {
		return sponsorships;
	}

	public void setSponsorships(List<Sponsorship> sponsorships) {
		this.sponsorships = sponsorships;
	}

	@Override
	public String toString() {
		return "User{" + "favorites=" + favorites + '}';
	}

	public String getUsername() {
		return super.getUsername();
	}

	public String getPassword() {
		return super.getPassword();
	}

	public String getGetPasswordConfirm() {
		return super.getGetPasswordConfirm();
	}

	public boolean isPremium() {
		return premium;
	}

	public void setPremium(boolean premium) {
		this.premium = premium;
	}

}
