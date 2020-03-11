package org.springframework.samples.oculusdb.model;

import org.hibernate.validator.constraints.Range;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "sponsors")
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
		return holderName;
	}

	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Integer getExpirationMonth() {
		return expirationMonth;
	}

	public void setExpirationMonth(Integer expirationMonth) {
		this.expirationMonth = expirationMonth;
	}

	public Integer getExpirationYear() {
		return expirationYear;
	}

	public void setExpirationYear(Integer expirationYear) {
		this.expirationYear = expirationYear;
	}

	public Integer getCVV() {
		return CVV;
	}

	public void setCVV(Integer CVV) {
		this.CVV = CVV;
	}

	@Override
	public String toString() {
		return "CreditCard{" + "holderName='" + holderName + '\'' + ", number=" + number + ", expirationMonth="
				+ expirationMonth + ", expirationYear=" + expirationYear + ", CVV=" + CVV + '}';
	}

}
