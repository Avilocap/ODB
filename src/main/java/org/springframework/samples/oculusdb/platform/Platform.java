
package org.springframework.samples.oculusdb.platform;

import org.springframework.samples.oculusdb.model.Application;
import org.springframework.samples.oculusdb.model.BaseEntity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Collection;

@Entity
@Table(name = "platform")
public class Platform extends BaseEntity {

	@Column(name = "title")
	@NotEmpty
	private String title;

	@Column(name = "description")
	private String description;

	@OneToMany(mappedBy = "platform")
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

	@Override
	public String toString() {
		return "Platform [title=" + this.title + ", description=" + this.description + "]";
	}

}
