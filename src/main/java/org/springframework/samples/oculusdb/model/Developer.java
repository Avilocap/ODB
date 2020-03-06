
package org.springframework.samples.oculusdb.model;

import javax.persistence.Entity;

@Entity
public class Developer extends Actor {

	private String		company;
	private String		webpage;
	private String		companyDescription;
//	private CreditCard	creditCard;


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

//	public CreditCard getCreditCard() {
//		return this.creditCard;
//	}
//
//	public void setCreditCard(final CreditCard creditCard) {
//		this.creditCard = creditCard;
//	}

//	@Override
//	public String toString() {
//		return "Developer [company=" + this.company + ", webpage=" + this.webpage + ", companyDescription=" + this.companyDescription + ", creditCard=" + this.creditCard + "]";
//	}

}
