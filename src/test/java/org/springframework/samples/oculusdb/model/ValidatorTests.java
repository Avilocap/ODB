package org.springframework.samples.oculusdb.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Locale;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.junit.jupiter.api.Test;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.samples.oculusdb.application.Comments;
import org.springframework.samples.oculusdb.model.Application;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

class ValidatorTests {

	private Validator createValidator() {
		LocalValidatorFactoryBean localValidatorFactoryBean = new LocalValidatorFactoryBean();
		localValidatorFactoryBean.afterPropertiesSet();
		return localValidatorFactoryBean;
	}

	@Test
	void shouldNotValidateWhenFirstNameEmpty() {

		LocaleContextHolder.setLocale(Locale.ENGLISH);
		Application application = new Application();
		application.setName("App1");
		application.setDescription("smith");

		Validator validator = createValidator();
		Set<ConstraintViolation<Application>> constraintViolations = validator.validate(application);

		assertThat(constraintViolations.size()).isEqualTo(1);
		ConstraintViolation<Application> violation = constraintViolations.iterator().next();
		assertThat(violation.getPropertyPath().toString()).isEqualTo("oculusId");
	}

	@Test
	void shouldNotValidateTitleEmpty() {
		Comments comment = new Comments();
		comment.setTitle("");
		comment.setContent("good comment");

		Validator validator = createValidator();
		Set<ConstraintViolation<Comments>> constraintViolations = validator.validate(comment);
		assertThat(constraintViolations.size()).isEqualTo(1);
		ConstraintViolation<Comments> violation = constraintViolations.iterator().next();
		assertThat(violation.getPropertyPath().toString()).isEqualTo("title");
	}

	@Test
	void shouldNotValidateContentEmpty() {
		Comments comment = new Comments();
		comment.setTitle("koaoa");
		comment.setContent("");

		Validator validator = createValidator();
		Set<ConstraintViolation<Comments>> constraintViolations = validator.validate(comment);
		assertThat(constraintViolations.size()).isEqualTo(1);
		ConstraintViolation<Comments> violation = constraintViolations.iterator().next();
		assertThat(violation.getPropertyPath().toString()).isEqualTo("content");
	}

}