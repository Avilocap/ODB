
package org.springframework.samples.oculusdb.application;

import org.springframework.samples.oculusdb.model.Application;
import org.springframework.samples.oculusdb.model.BaseEntity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "comment")
public class Comments extends BaseEntity {

	@Column(name = "title")
	@NotEmpty
	private String title;

	@Column(name = "content")
	@NotEmpty
	private String content;

	@ManyToOne
	private Application application;

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
		return application;
	}

	public void setApplication(Application application) {
		this.application = application;
	}

	@Override
	public String toString() {
		return "Comments{" +
				"title='" + title + '\'' +
				", content='" + content + '\'' +
				", application=" + application +
				'}';
	}
}
