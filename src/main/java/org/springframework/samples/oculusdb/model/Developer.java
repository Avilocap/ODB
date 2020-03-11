
package org.springframework.samples.oculusdb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "developer")
public class Developer extends Actor {

	@Column(name = "company")
	@NotEmpty
	private String company;

	@Column(name = "webpage")
	private String webpage;

	@Column(name = "company_description")
	private String companyDescription;

	@OneToOne
	private CreditCard creditCard;

	public String getCompany() {
		return this.company;
	}

	public void setCompany(final String company) {
		this.company = company;
	}

	public String getWebpage() {
		return this.webpage;
	}

	public void setWebpage(final String webpage) {
		this.webpage = webpage;
	}

	public String getCompanyDescription() {
		return this.companyDescription;
	}

	public void setCompanyDescription(final String companyDescription) {
		this.companyDescription = companyDescription;
	}

	public CreditCard getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(CreditCard creditCard) {
		this.creditCard = creditCard;
	}

	@Override
	public String toString() {
		return "Developer{" + "company='" + company + '\'' + ", webpage='" + webpage + '\'' + ", companyDescription='"
				+ companyDescription + '\'' + ", creditCard=" + creditCard + '}';
	}

}
