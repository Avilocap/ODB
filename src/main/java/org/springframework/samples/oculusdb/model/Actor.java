
package org.springframework.samples.oculusdb.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@MappedSuperclass
public class Actor extends BaseEntity {

	@Column(name = "username")
	@NotEmpty
	private String username;

	@Column(name = "password")
	@NotEmpty
	private String password;

	@Transient
	private String getPasswordConfirm;

	@ManyToMany(fetch = FetchType.EAGER)
	@Column(name = "roles")
	private Set<Role> roles;

	@Column(name = "name")
	@NotEmpty
	private String name;

	@Column(name = "surname")
	@NotEmpty
	private String surname;

	@Column(name = "email")
	@NotEmpty
	private String email;

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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGetPasswordConfirm() {
		return getPasswordConfirm;
	}

	public void setGetPasswordConfirm(String getPasswordConfirm) {
		this.getPasswordConfirm = getPasswordConfirm;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "Actor [name=" + this.name + ", surname=" + this.surname + ", email=" + this.email;
	}

}
