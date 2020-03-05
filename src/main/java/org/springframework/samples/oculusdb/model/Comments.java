
package org.springframework.samples.oculusdb.model;

import javax.persistence.Entity;

@Entity
public class Comments {

	private String	title;
	private String	content;


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

	@Override
	public String toString() {
		return "Comments [title=" + this.title + ", content=" + this.content + "]";
	}

}
