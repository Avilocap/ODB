
package org.springframework.samples.oculusdb.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "actors")
public class Actor extends UserAccount {

	@Column(name = "name")
	@NotEmpty
	private String name;

	@Column(name = "surname")
	@NotEmpty
	private String surname;

	@Column(name = "email")
	@NotEmpty
	private String email;

	// @OneToOne(cascade = CascadeType.ALL, mappedBy = "actor")
	// private UserAccount userAccount;

	// public UserAccount getUserAccount() {
	// return this.userAccount;
	// }
	//
	// public void setUserAccount(final UserAccount userAccount) {
	// this.userAccount = userAccount;
	// }

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

	// @Override
	// public String toString() {
	// return "Actor [name=" + this.name + ", surname=" + this.surname + ", email=" +
	// this.email + ", userAccount=" + this.userAccount + "]";
	// }

}
