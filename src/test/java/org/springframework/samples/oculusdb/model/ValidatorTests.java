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
	void shouldNotValidateWhenIdEmpty() {
		LocaleContextHolder.setLocale(Locale.ENGLISH);
		Application application = new Application();
		application.setName("app1");
		application.setDescription("smith");

		Validator validator = createValidator();
		Set<ConstraintViolation<Application>> constraintViolations = validator.validate(application);

		assertThat(constraintViolations.size()).isEqualTo(1);
		ConstraintViolation<Application> violation = constraintViolations.iterator().next();
		assertThat(violation.getPropertyPath().toString()).isEqualTo("oculusId");
	}

	@Test
	void shouldNotValidateNameEmpty() {
		LocaleContextHolder.setLocale(Locale.ENGLISH);
		Application application = new Application();
		application.setOculusId("102");
		application.setDescription("smith");

		Validator validator = createValidator();
		Set<ConstraintViolation<Application>> constraintViolations = validator.validate(application);

		assertThat(constraintViolations.size()).isEqualTo(1);
		ConstraintViolation<Application> violation = constraintViolations.iterator().next();
		assertThat(violation.getPropertyPath().toString()).isEqualTo("name");
	}

	@Test
	void shouldNotValidateNameUserEmpty() {
		LocaleContextHolder.setLocale(Locale.ENGLISH);
		User user = new User();
		user.setSurname("Gallardo");
		user.setEmail("deokw@gmail.com");

		Validator validator = createValidator();
		Set<ConstraintViolation<User>> constraintViolations = validator.validate(user);

		assertThat(constraintViolations.size()).isEqualTo(1);
		ConstraintViolation<User> violation = constraintViolations.iterator().next();
		assertThat(violation.getPropertyPath().toString()).isEqualTo("name");
	}

	@Test
	void shouldNotValidateSurnameUserEmpty() {
		LocaleContextHolder.setLocale(Locale.ENGLISH);
		User user = new User();
		user.setName("Josema");
		user.setEmail("deokw@gmail.com");

		Validator validator = createValidator();
		Set<ConstraintViolation<User>> constraintViolations = validator.validate(user);

		assertThat(constraintViolations.size()).isEqualTo(1);
		ConstraintViolation<User> violation = constraintViolations.iterator().next();
		assertThat(violation.getPropertyPath().toString()).isEqualTo("surname");
	}

	@Test
	void shouldNotValidateEmailUserEmpty() {
		LocaleContextHolder.setLocale(Locale.ENGLISH);
		User user = new User();
		user.setName("Josema");
		user.setSurname("Gallardo");

		Validator validator = createValidator();
		Set<ConstraintViolation<User>> constraintViolations = validator.validate(user);

		assertThat(constraintViolations.size()).isEqualTo(1);
		ConstraintViolation<User> violation = constraintViolations.iterator().next();
		assertThat(violation.getPropertyPath().toString()).isEqualTo("email");
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

	@Test
	void shouldNotValidateHolderNameEmpty() {
		CreditCard creditCard = new CreditCard();
		creditCard.setNumber(343049239);
		creditCard.setExpirationMonth(7);
		creditCard.setExpirationYear(2022);
		creditCard.setCVV(527);

		Validator validator = createValidator();
		Set<ConstraintViolation<CreditCard>> constraintViolations = validator.validate(creditCard);
		assertThat(constraintViolations.size()).isEqualTo(1);
		ConstraintViolation<CreditCard> violation = constraintViolations.iterator().next();
		assertThat(violation.getPropertyPath().toString()).isEqualTo("holderName");
	}

	@Test
	void shouldNotValidateNumberCardEmpty() {
		CreditCard creditCard = new CreditCard();
		creditCard.setHolderName("Josema");
		creditCard.setExpirationMonth(7);
		creditCard.setExpirationYear(2022);
		creditCard.setCVV(527);

		Validator validator = createValidator();
		Set<ConstraintViolation<CreditCard>> constraintViolations = validator.validate(creditCard);
		assertThat(constraintViolations.size()).isEqualTo(1);
		ConstraintViolation<CreditCard> violation = constraintViolations.iterator().next();
		assertThat(violation.getPropertyPath().toString()).isEqualTo("number");
	}

	@Test
	void shouldNotValidateExpirationDateEmpty() {
		CreditCard creditCard = new CreditCard();
		creditCard.setHolderName("Josema");
		creditCard.setNumber(832582485);
		creditCard.setExpirationYear(2020);
		creditCard.setCVV(527);

		Validator validator = createValidator();
		Set<ConstraintViolation<CreditCard>> constraintViolations = validator.validate(creditCard);
		assertThat(constraintViolations.size()).isEqualTo(1);
		ConstraintViolation<CreditCard> violation = constraintViolations.iterator().next();
		assertThat(violation.getPropertyPath().toString()).isEqualTo("expirationMonth");
	}

	@Test
	void shouldNotValidateExpirationDateEmpty2() {
		CreditCard creditCard = new CreditCard();
		creditCard.setHolderName("Josema");
		creditCard.setNumber(832582485);
		creditCard.setExpirationMonth(4);
		creditCard.setCVV(527);

		Validator validator = createValidator();
		Set<ConstraintViolation<CreditCard>> constraintViolations = validator.validate(creditCard);
		assertThat(constraintViolations.size()).isEqualTo(1);
		ConstraintViolation<CreditCard> violation = constraintViolations.iterator().next();
		assertThat(violation.getPropertyPath().toString()).isEqualTo("expirationYear");
	}

	@Test
	void shouldNotValidateCVVEmpty() {
		CreditCard creditCard = new CreditCard();
		creditCard.setHolderName("Josema");
		creditCard.setNumber(832582485);
		creditCard.setExpirationMonth(4);
		creditCard.setExpirationYear(2025);

		Validator validator = createValidator();
		Set<ConstraintViolation<CreditCard>> constraintViolations = validator.validate(creditCard);
		assertThat(constraintViolations.size()).isEqualTo(1);
		ConstraintViolation<CreditCard> violation = constraintViolations.iterator().next();
		assertThat(violation.getPropertyPath().toString()).isEqualTo("CVV");
	}





}