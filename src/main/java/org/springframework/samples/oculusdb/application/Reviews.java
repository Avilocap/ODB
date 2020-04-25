
package org.springframework.samples.oculusdb.application;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.samples.oculusdb.model.Application;
import org.springframework.samples.oculusdb.model.BaseEntity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.Collection;

@Entity
@Table(name = "reviews")
public class Reviews extends BaseEntity {

	@Column(name = "oculusId")
	@NotEmpty
	private String oculusId;

	@Lob
	@Column(name = "title", columnDefinition = "LONGTEXT")
	@NotEmpty
	private String title;

	@Lob
	@Column(name = "content", columnDefinition = "LONGTEXT")
	@NotEmpty
	private String content;

	@Column(name = "publishDate")
	@DateTimeFormat(pattern = "dd-mm-yyyy")
	private LocalDate publishDate;

	@ManyToOne
	private Application application;

	public String getOculusId() {
		return this.oculusId;
	}

	public void setOculusId(final String oculusId) {
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

	public LocalDate getPublishDate() {
		return this.publishDate;
	}

	public void setPublishDate(final LocalDate publishDate) {
		this.publishDate = publishDate;
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
				+ ", publishDate='" + publishDate + '\'' + ", application=" + application + '}';
	}

}
