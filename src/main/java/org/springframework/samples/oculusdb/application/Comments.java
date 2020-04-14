
package org.springframework.samples.oculusdb.application;

import org.springframework.samples.oculusdb.model.Application;
import org.springframework.samples.oculusdb.model.BaseEntity;
import org.springframework.samples.oculusdb.model.User;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "comments")
public class Comments extends BaseEntity {

	@Column(name = "title")
	@NotEmpty
	private String title;

	@Column(name = "content")
	@NotEmpty
	private String content;

	@ManyToOne
	private Application application;

	@ManyToOne
	private User owner;

	public String getTitle() {
		return this.title;
	}

	public void setTitle(final String title) {
		this.title = title;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(final String content) {
		this.content = content;
	}

	public Application getApplication() {
		return this.application;
	}

	public void setApplication(final Application application) {
		this.application = application;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	@Override
	public String toString() {
		return "Comments{" + "title='" + title + '\'' + ", content='" + content + '\'' + ", application=" + application
				+ ", owner=" + owner + '}';
	}

}
