
package org.springframework.samples.oculusdb.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User extends Actor {

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
