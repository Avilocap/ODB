
package org.springframework.samples.oculusdb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

@Entity
@Table(name = "credit_cards")
public class CreditCard extends BaseEntity {

	@Column(name = "holder_name")
	@NotEmpty
	private String holderName;

	@Column(name = "number")
	@NotNull
	private Integer number;

	@Column(name = "expiration_month")
	@NotNull
	@Range(min = 1, max = 12)
	private Integer expirationMonth;

	@Column(name = "expiration_year")
	@NotNull
	@Range(min = 2020, max = 2027)
	private Integer expirationYear;

	@Column(name = "cvv")
	@NotNull
	@Range(min = 001, max = 999)
	private Integer CVV;

	public String getHolderName() {
		return this.holderName;
	}

	public void setHolderName(final String holderName) {
		this.holderName = holderName;
	}

	public Integer getNumber() {
		return this.number;
	}

	public void setNumber(final Integer number) {
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

	public Integer getCVV() {
		return this.CVV;
	}

	public void setCVV(final Integer CVV) {
		this.CVV = CVV;
	}

	@Override
	public String toString() {
		return "CreditCard{" + "holderName='" + this.holderName + '\'' + ", number=" + this.number
				+ ", expirationMonth=" + this.expirationMonth + ", expirationYear=" + this.expirationYear + ", CVV="
				+ this.CVV + '}';
	}

}
