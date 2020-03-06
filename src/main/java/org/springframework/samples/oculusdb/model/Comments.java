
package org.springframework.samples.oculusdb.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Comments {

	private Integer id;

	private String title;

	private String content;

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

	@Id
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Comments [title=" + this.title + ", content=" + this.content + "]";
	}

}
