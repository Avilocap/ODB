
package org.springframework.samples.oculusdb.model;

import org.hibernate.validator.constraints.Range;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "word")
public class Word extends BaseEntity {

	@Column(name = "letters")
	@NotEmpty
	private String letters;

	@Column(name = "repeats")
	@NotNull
	private Integer repeats;

	public String getLetters() {
		return letters;
	}

	public void setLetters(String letters) {
		this.letters = letters;
	}

	public Integer getRepeats() {
		return repeats;
	}

	public void setRepeats(Integer repeats) {
		this.repeats = repeats;
	}

	@Override
	public String toString() {
		return "Word{" + "letters='" + letters + '\'' + ", repeats=" + repeats + '}';
	}

}
