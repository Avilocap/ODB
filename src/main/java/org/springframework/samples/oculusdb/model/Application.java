
package org.springframework.samples.oculusdb.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Application {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer oculusId;

	private String name;

	private String description;

	private LocalDate releaseDate;

	private Double price;

	private String website;

	private String company;

	private String picture;

	private TypeOfGameplay typeOfGameplay;

	private Integer salesEstimation;

	private Integer incomeEstimation;

	private Integer totalReviews;

	private String language;

	private TypeOfApp typeOfApp;

	// @OneToMany(cascade = CascadeType.ALL, mappedBy = "application")
	// private Platform platform;
	//
	// @OneToMany(cascade = CascadeType.ALL, mappedBy = "application")
	// private Category category;
	//
	// @OneToMany(cascade = CascadeType.ALL, mappedBy = "application")
	// private Reviews reviews;
	//
	// @OneToMany(cascade = CascadeType.ALL, mappedBy = "application")
	// private Comments comments;

	public Integer getOculusId() {
		return this.oculusId;
	}

	public void setOculusId(final Integer oculusId) {
		this.oculusId = oculusId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(final String description) {
		this.description = description;
	}

	public LocalDate getReleaseDate() {
		return this.releaseDate;
	}

	public void setReleaseDate(final LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}

	public Double getPrice() {
		return this.price;
	}

	public void setPrice(final Double price) {
		this.price = price;
	}

	public String getWebsite() {
		return this.website;
	}

	public void setWebsite(final String website) {
		this.website = website;
	}

	public String getCompany() {
		return this.company;
	}

	public void setCompany(final String company) {
		this.company = company;
	}

	public String getPicture() {
		return this.picture;
	}

	public void setPicture(final String picture) {
		this.picture = picture;
	}

	public TypeOfGameplay getTypeOfGameplay() {
		return this.typeOfGameplay;
	}

	public void setTypeOfGameplay(final TypeOfGameplay typeOfGameplay) {
		this.typeOfGameplay = typeOfGameplay;
	}

	public Integer getSalesEstimation() {
		return this.salesEstimation;
	}

	public void setSalesEstimation(final Integer salesEstimation) {
		this.salesEstimation = salesEstimation;
	}

	public Integer getIncomeEstimation() {
		return this.incomeEstimation;
	}

	public void setIncomeEstimation(final Integer incomeEstimation) {
		this.incomeEstimation = incomeEstimation;
	}

	public Integer getTotalReviews() {
		return this.totalReviews;
	}

	public void setTotalReviews(final Integer totalReviews) {
		this.totalReviews = totalReviews;
	}

	public String getLanguage() {
		return this.language;
	}

	public void setLanguage(final String language) {
		this.language = language;
	}

	public TypeOfApp getTypeOfApp() {
		return this.typeOfApp;
	}

	public void setTypeOfApp(final TypeOfApp typeOfApp) {
		this.typeOfApp = typeOfApp;
	}

	// public Platform getPlatform() {
	// return this.platform;
	// }
	//
	// public void setPlatform(final Platform platform) {
	// this.platform = platform;
	// }
	//
	// public Category getCategory() {
	// return this.category;
	// }
	//
	// public void setCategory(final Category category) {
	// this.category = category;
	// }
	//
	// public Reviews getReviews() {
	// return this.reviews;
	// }
	//
	// public void setReviews(final Reviews reviews) {
	// this.reviews = reviews;
	// }
	//
	// public Comments getComments() {
	// return this.comments;
	// }
	//
	// public void setComments(final Comments comments) {
	// this.comments = comments;
	// }

	// @Override
	// public String toString() {
	// return "Application [oculusId=" + this.oculusId + ", name=" + this.name + ",
	// description=" + this.description + ", releaseDate=" + this.releaseDate + ", price="
	// + this.price + ", website=" + this.website + ", company=" + this.company + ",
	// picture="
	// + this.picture + ", typeOfGameplay=" + this.typeOfGameplay + ", salesEstimation=" +
	// this.salesEstimation + ", incomeEstimation=" + this.incomeEstimation + ",
	// totalReviews=" + this.totalReviews + ", language=" + this.language + ", typeOfApp="
	// + this.typeOfApp + ", platform=" + this.platform + ", category=" + this.category +
	// ", reviews=" + this.reviews + ", comments=" + this.comments + "]";
	// }

}
