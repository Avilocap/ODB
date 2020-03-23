
package org.springframework.samples.oculusdb.model;

import org.apache.tomcat.jni.Local;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.samples.oculusdb.application.Comments;
import org.springframework.samples.oculusdb.application.Reviews;
import org.springframework.samples.oculusdb.category.Category;
import org.springframework.samples.oculusdb.platform.Platform;

import java.time.LocalDate;
import java.util.Collection;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "application")
public class Application extends BaseEntity {

	public Application() {

	}

	public Application(String oculusId, String name, String description, LocalDate releaseDate, Double price,
			String website, String company, String picture, Integer incomeEstimation, Integer salesEstimation,
			Integer totalReviews) {
		this.oculusId = oculusId;
		this.name = name;
		this.description = description;
		this.releaseDate = releaseDate;
		this.price = price;
		this.website = website;
		this.company = company;
		this.picture = picture;
		this.incomeEstimation = incomeEstimation;
		this.salesEstimation = salesEstimation;
		this.totalReviews = totalReviews;
	}

	@Column(name = "oculusDBId")
	@NotEmpty
	private String oculusId;

	@Column(name = "name")
	@NotEmpty
	private String name;

	@Lob
	@Column(name = "description", columnDefinition = "LONGTEXT")
	private String description;

	@Column(name = "releaseDate")
	@DateTimeFormat(pattern = "mm-dd-yyyy")
	private LocalDate releaseDate;

	@Column(name = "price")
	private Double price;

	@Column(name = "website")
	private String website;

	@Column(name = "company")
	private String company;

	@Lob
	@Column(name = "picture", columnDefinition = "LONGTEXT")
	private String picture;

	@Column(name = "type_of_gameplay")
	private TypeOfGameplay typeOfGameplay;

	@Column(name = "sales_estimations")
	private Integer salesEstimation;

	@Column(name = "income_estimation")
	private Integer incomeEstimation;

	@Column(name = "total_reviews")
	private Integer totalReviews;

	@Column(name = "language")
	private String language;

	@Column(name = "typeOfApp")
	private TypeOfApp typeOfApp;

	@ManyToOne
	private Platform platform;

	@ManyToOne
	private Category category;

	@OneToMany(mappedBy = "application", cascade = CascadeType.ALL)
	private Collection<Reviews> reviewsCollection;

	@OneToMany(mappedBy = "application", cascade = CascadeType.ALL)
	private Collection<Comments> comments;

	public String getOculusId() {
		return this.oculusId;
	}

	public void setOculusId(final String oculusId) {
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

	public Platform getPlatform() {
		return platform;
	}

	public void setPlatform(Platform platform) {
		this.platform = platform;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Collection<Reviews> getReviewsCollection() {
		return reviewsCollection;
	}

	public void setReviewsCollection(Collection<Reviews> reviewsCollection) {
		this.reviewsCollection = reviewsCollection;
	}

	public Collection<Comments> getComments() {
		return comments;
	}

	public void setComments(Collection<Comments> comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "Application{" + "oculusId=" + oculusId + ", name='" + name + '\'' + ", description='" + description
				+ '\'' + ", releaseDate=" + releaseDate + ", price=" + price + ", website='" + website + '\''
				+ ", company='" + company + '\'' + ", picture='" + picture + '\'' + ", typeOfGameplay=" + typeOfGameplay
				+ ", salesEstimation=" + salesEstimation + ", incomeEstimation=" + incomeEstimation + ", totalReviews="
				+ totalReviews + ", language='" + language + '\'' + ", typeOfApp=" + typeOfApp + ", platform="
				+ platform + ", category=" + category + ", reviewsCollection=" + reviewsCollection + ", comments="
				+ comments + '}';
	}

}
