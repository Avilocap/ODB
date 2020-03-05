
package org.springframework.samples.oculusdb.model;

import javax.persistence.Entity;

@Entity
public class Actor extends UserAccount {

	private String		name;
	private String		surname;
	private String		email;
	private UserAccount	userAccount;


	public UserAccount getUserAccount() {
		return this.userAccount;
	}

	public void setUserAccount(final UserAccount userAccount) {
		this.userAccount = userAccount;
	}

	public String getName() {
		return this.name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setSurname(final String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(final String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Actor [name=" + this.name + ", surname=" + this.surname + ", email=" + this.email + ", userAccount=" + this.userAccount + "]";
	}

}
