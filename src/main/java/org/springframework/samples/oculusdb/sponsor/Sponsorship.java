
package org.springframework.samples.oculusdb.sponsor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.springframework.samples.oculusdb.model.BaseEntity;
import org.springframework.samples.oculusdb.model.User;

@Entity
@Table(name = "sponsorship")
public class Sponsorship extends BaseEntity {

	@Column(name = "title")
	@NotEmpty
	private String title;

	@Column(name = "attachmentURL")
	@NotEmpty
	private String attachmentUrl;

	@ManyToOne
	private User user;

	public String getTitle() {
		return this.title;
	}

	public void setTitle(final String title) {
		this.title = title;
	}

	public String getAttachmentUrl() {
		return this.attachmentUrl;
	}

	public void setAttachmentUrl(final String attachmentUrl) {
		this.attachmentUrl = attachmentUrl;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Sponsorship [title=" + this.title + ", attachmentUrl=" + this.attachmentUrl + "]";
	}

}
