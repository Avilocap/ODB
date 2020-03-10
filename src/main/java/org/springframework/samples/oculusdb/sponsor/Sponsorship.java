
package org.springframework.samples.oculusdb.sponsor;

import org.springframework.samples.oculusdb.model.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "sponsorhip")
public class Sponsorship extends BaseEntity {

	@Column(name = "title")
	@NotEmpty
	private String title;

	@Column(name = "attachmentURL")
	@NotEmpty
	private String attachmentUrl;

	@ManyToOne
	private Sponsor sponsor;

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

	public Sponsor getSponsor() {
		return sponsor;
	}

	public void setSponsor(Sponsor sponsor) {
		this.sponsor = sponsor;
	}

	@Override
	public String toString() {
		return "Sponsorship [title=" + this.title + ", attachmentUrl=" + this.attachmentUrl + "]";
	}

}
