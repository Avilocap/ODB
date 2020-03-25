
package org.springframework.samples.oculusdb.category;

import org.springframework.samples.oculusdb.model.Application;
import org.springframework.samples.oculusdb.model.BaseEntity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Collection;

@Entity
@Table(name = "category")
public class Category extends BaseEntity {

	@Column(name = "title")
	@NotEmpty
	private String title;

	@Column(name = "description")
	private String description;

	@OneToMany(mappedBy = "category")
	private Collection<Application> applications;

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

	public Collection<Application> getApplications() {
		return applications;
	}

	public void setApplications(Collection<Application> applications) {
		this.applications = applications;
	}

	@Override
	public String toString() {
		return this.title + " ~ " + this.description;
	}

}
