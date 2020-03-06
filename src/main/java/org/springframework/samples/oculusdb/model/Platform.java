
package org.springframework.samples.oculusdb.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Platform {

	private Integer id;

	private String title;

	private String description;

	@Id
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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
		return "Platform [title=" + this.title + ", description=" + this.description + "]";
	}

}
