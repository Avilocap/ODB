
package org.springframework.samples.oculusdb.model;

import javax.persistence.Entity;

@Entity
public class Category {

	private String	title;
	private String	description;


	public String getTitle() {
		return this.title;
	}

	public void setTitle(final String title) {
		this.title = title;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(final String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Category [title=" + this.title + ", description=" + this.description + "]";
	}

}
