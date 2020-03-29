
package org.springframework.samples.oculusdb.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User extends Actor {

	@OneToMany(fetch = FetchType.EAGER)
	private List<Application> favorites;

	public List<Application> getFavorites() {
		return favorites;
	}

	public void setFavorites(List<Application> favorites) {
		this.favorites = favorites;
	}

	public User() {
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

}
