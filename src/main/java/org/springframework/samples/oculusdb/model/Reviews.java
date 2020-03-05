
package org.springframework.samples.oculusdb.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Reviews {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer	oculusId;
	private String	title;
	private String	content;
	private String	publishDate;
	private Boolean	usefull;


	public Integer getOculusId() {
		return this.oculusId;
	}

	public void setOculusId(final Integer oculusId) {
		this.oculusId = oculusId;
	}

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

	public String getPublishDate() {
		return this.publishDate;
	}

	public void setPublishDate(final String publishDate) {
		this.publishDate = publishDate;
	}

	public Boolean getUsefull() {
		return this.usefull;
	}

	public void setUsefull(final Boolean usefull) {
		this.usefull = usefull;
	}

	@Override
	public String toString() {
		return "Reviews [oculusId=" + this.oculusId + ", title=" + this.title + ", content=" + this.content + ", publishDate=" + this.publishDate + ", usefull=" + this.usefull + "]";
	}

}
