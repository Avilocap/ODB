
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

	@Column(name = "active")
	private boolean active;

	@OneToMany
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Sponsorship> sponsorships;

	public List<Application> getFavorites() {
		return favorites;
	}

	public void setFavorites(List<Application> favorites) {
		this.favorites = favorites;
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

	@Override
	public String getUsername() {
		return super.getUsername();
	}

	@Override
	public String getPassword() {
		return super.getPassword();
	}

	@Override
	public String getGetPasswordConfirm() {
		return super.getGetPasswordConfirm();
	}

	public boolean isPremium() {
		return premium;
	}

	public void setPremium(boolean premium) {
		this.premium = premium;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

}
