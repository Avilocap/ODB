
package org.springframework.samples.oculusdb.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotEmpty;

@MappedSuperclass
public class UserAccount extends BaseEntity {

	@Column(name = "nick")
	@NotEmpty
	private String	nick;

	@Column(name = "password")
	@NotEmpty
	private String	password;

	@Column(name = "authority")
	@NotEmpty
	private String	authority;


	public String getNick() {
		return this.nick;
	}

	public void setNick(final String nick) {
		this.nick = nick;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(final String password) {
		this.password = password;
	}

	public String getAuthority() {
		return this.authority;
	}

	public void setAuthority(final String authority) {
		this.authority = authority;
	}

	@Override
	public String toString() {
		return "UserAccount [nick=" + this.nick + ", password=" + this.password + ", authority=" + this.authority + "]";
	}

}
