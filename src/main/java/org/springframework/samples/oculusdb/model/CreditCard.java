
package org.springframework.samples.oculusdb.model;

import javax.persistence.Entity;

@Entity
public class CreditCard {

	private String	holderName;
	private String	number;
	private Integer	expirationMonth;
	private Integer	expirationYear;
	private Integer	cvv;


	public String getHolderName() {
		return this.holderName;
	}

	public void setHolderName(final String holderName) {
		this.holderName = holderName;
	}

	public String getNumber() {
		return this.number;
	}

	public void setNumber(final String number) {
		this.number = number;
	}

	public Integer getExpirationMonth() {
		return this.expirationMonth;
	}

	public void setExpirationMonth(final Integer expirationMonth) {
		this.expirationMonth = expirationMonth;
	}

	public Integer getExpirationYear() {
		return this.expirationYear;
	}

	public void setExpirationYear(final Integer expirationYear) {
		this.expirationYear = expirationYear;
	}

	public Integer getCvv() {
		return this.cvv;
	}

	public void setCvv(final Integer cvv) {
		this.cvv = cvv;
	}

	@Override
	public String toString() {
		return "CreditCard [holderName=" + this.holderName + ", number=" + this.number + ", expirationMonth=" + this.expirationMonth + ", expirationYear=" + this.expirationYear + ", cvv=" + this.cvv + "]";
	}

}
