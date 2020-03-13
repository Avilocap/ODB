
package org.springframework.samples.oculusdb.application;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.springframework.samples.oculusdb.model.Application;
import org.springframework.samples.oculusdb.model.BaseEntity;

@Entity
@Table(name = "comments")
public class Comments extends BaseEntity {

	@Column(name = "title")
	@NotEmpty
	private String		title;

	@Column(name = "content")
	@NotEmpty
	private String		content;

	@ManyToOne
	private Application	application;


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

	@Override
	public String toString() {
		return "Comments{" + "title='" + this.title + '\'' + ", content='" + this.content + '\'' + ", application=" + this.application + '}';
	}

}
