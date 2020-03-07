
package org.springframework.samples.oculusdb.model;

public class Sponsorship {

	private String title;

	private String attachmentUrl;

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

	@Override
	public String toString() {
		return "Sponsorship [title=" + this.title + ", attachmentUrl=" + this.attachmentUrl + "]";
	}

}
