
package org.springframework.samples.oculusdb.application;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.samples.oculusdb.model.Application;
import org.springframework.samples.oculusdb.model.BaseEntity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Collection;

@Entity
@Table(name = "reviews")
public class Reviews extends BaseEntity {

	@Column(name = "oculusId")
	@NotEmpty
	private Integer oculusId;

	@Column(name = "title")
	@NotEmpty
	private String title;

	@Column(name = "content")
	@NotEmpty
	private String content;

	@Column(name = "publishDate")
	@NotEmpty
	@DateTimeFormat(pattern = "dd-mm-yyyy")
	private String publishDate;

	@Column(name = "usefull")
	private Boolean usefull;

	@ManyToOne
	private Application application;

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

	public Application getApplication() {
		return application;
	}

	public void setApplication(Application application) {
		this.application = application;
	}

	@Override
	public String toString() {
		return "Reviews{" + "oculusId=" + oculusId + ", title='" + title + '\'' + ", content='" + content + '\''
				+ ", publishDate='" + publishDate + '\'' + ", usefull=" + usefull + ", application=" + application
				+ '}';
	}

}
