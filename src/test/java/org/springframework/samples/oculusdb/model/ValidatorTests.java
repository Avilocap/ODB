package org.springframework.samples.oculusdb.model;

import org.junit.jupiter.api.Test;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.samples.oculusdb.application.Comments;
import org.springframework.samples.oculusdb.category.Category;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@Transactional
class ValidatorTests {

	private Validator createValidator() {
		LocalValidatorFactoryBean localValidatorFactoryBean = new LocalValidatorFactoryBean();
		localValidatorFactoryBean.afterPropertiesSet();
		return localValidatorFactoryBean;
	}

	@Test
	void shouldValidateAppWithAllParameters() {
		LocaleContextHolder.setLocale(Locale.ENGLISH);
		Application application = new Application();
		application.setName("app1");
		application.setDescription("smith");
		application.setOculusId("8975424654");
		Validator validator = createValidator();
		Set<ConstraintViolation<Application>> constraintViolations = validator.validate(application);
		assertThat(constraintViolations.size()).isEqualTo(0);
	}

	@Test
	void shouldNotValidateAppWhenIdEmpty() {
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
	void shouldNotValidateAppNameEmpty() {
		LocaleContextHolder.setLocale(Locale.ENGLISH);
		Application application = new Application();
		application.setOculusId("102");
		application.setDescription("smith");
		application.setName("");

		Validator validator = createValidator();
		Set<ConstraintViolation<Application>> constraintViolations = validator.validate(application);

		assertThat(constraintViolations.size()).isEqualTo(1);
		ConstraintViolation<Application> violation = constraintViolations.iterator().next();
		assertThat(violation.getPropertyPath().toString()).isEqualTo("name");
	}

	@Test
	void shouldNotValidateAppNameNull() {
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
	void shouldValidateUserWithAllParameters() {
		LocaleContextHolder.setLocale(Locale.ENGLISH);
		User user = new User();
		user.setSurname("Gallardo");
		user.setEmail("deokw@gmail.com");
		user.setName("Name");
		user.setUsername("username");
		user.setPassword("password");
		Validator validator = createValidator();
		Set<ConstraintViolation<User>> constraintViolations = validator.validate(user);
		Assert.isTrue((constraintViolations.size()) == (0));

	}

	@Test
	void shouldNotValidateNameUserNull() {
		LocaleContextHolder.setLocale(Locale.ENGLISH);
		User user = new User();
		user.setSurname("Gallardo");
		user.setEmail("deokw@gmail.com");
		user.setName(null);

		Validator validator = createValidator();
		Set<ConstraintViolation<User>> constraintViolations = validator.validate(user);

		Assert.isTrue((constraintViolations.size()) == (3));
		ConstraintViolation<User> violation = constraintViolations.iterator().next();
		Assert.isTrue(Objects.equals(violation.getPropertyPath().toString(), "username")
				|| Objects.equals(violation.getPropertyPath().toString(), "password")
				|| Objects.equals(violation.getPropertyPath().toString(), "name"));
	}

	@Test
	void shouldNotValidateNameUserEmpty() {
		LocaleContextHolder.setLocale(Locale.ENGLISH);
		User user = new User();
		user.setSurname("Gallardo");
		user.setEmail("deokw@gmail.com");

		Validator validator = createValidator();
		Set<ConstraintViolation<User>> constraintViolations = validator.validate(user);

		Assert.isTrue((constraintViolations.size()) == (3));
		ConstraintViolation<User> violation = constraintViolations.iterator().next();
		Assert.isTrue((Objects.equals(violation.getPropertyPath().toString(), "username")
				|| Objects.equals(violation.getPropertyPath().toString(), "password")
				|| Objects.equals(violation.getPropertyPath().toString(), "name")));
	}

	@Test
	void shouldNotValidateSurnameUserNameEmpty() {
		LocaleContextHolder.setLocale(Locale.ENGLISH);
		User user = new User();
		user.setName("Josema");
		user.setEmail("deokw@gmail.com");
		user.setUsername("");

		Validator validator = createValidator();
		Set<ConstraintViolation<User>> constraintViolations = validator.validate(user);

		Assert.isTrue((constraintViolations.size()) == (3));
		ConstraintViolation<User> violation = constraintViolations.iterator().next();
		Assert.isTrue((Objects.equals(violation.getPropertyPath().toString(), "username")
				|| Objects.equals(violation.getPropertyPath().toString(), "surname")
				|| Objects.equals(violation.getPropertyPath().toString(), "name")
				|| Objects.equals(violation.getPropertyPath().toString(), "password")));
	}

	@Test
	void shouldNotValidateSurnameUserNameNull() {
		LocaleContextHolder.setLocale(Locale.ENGLISH);
		User user = new User();
		user.setName("Josema");
		user.setEmail("deokw@gmail.com");

		Validator validator = createValidator();
		Set<ConstraintViolation<User>> constraintViolations = validator.validate(user);

		Assert.isTrue((constraintViolations.size()) == (3));
		ConstraintViolation<User> violation = constraintViolations.iterator().next();
		Assert.isTrue((Objects.equals(violation.getPropertyPath().toString(), "username")
				|| Objects.equals(violation.getPropertyPath().toString(), "password")
				|| Objects.equals(violation.getPropertyPath().toString(), "surname")));
	}

	@Test
	void shouldNotValidateEmailUserEmpty() {
		LocaleContextHolder.setLocale(Locale.ENGLISH);
		User user = new User();
		user.setName("Josema");
		user.setSurname("Gallardo");
		user.setEmail("");

		Validator validator = createValidator();
		Set<ConstraintViolation<User>> constraintViolations = validator.validate(user);

		Assert.isTrue((constraintViolations.size()) == (3));
		ConstraintViolation<User> violation = constraintViolations.iterator().next();
		Assert.isTrue((Objects.equals(violation.getPropertyPath().toString(), "username")
				|| Objects.equals(violation.getPropertyPath().toString(), "password")
				|| Objects.equals(violation.getPropertyPath().toString(), "email")));
	}

	@Test
	void shouldNotValidateEmailUserNull() {
		LocaleContextHolder.setLocale(Locale.ENGLISH);
		User user = new User();
		user.setName("Josema");
		user.setSurname("Gallardo");

		Validator validator = createValidator();
		Set<ConstraintViolation<User>> constraintViolations = validator.validate(user);

		Assert.isTrue((constraintViolations.size()) == (3));
		ConstraintViolation<User> violation = constraintViolations.iterator().next();
		Assert.isTrue((violation.getPropertyPath().toString().equals("password")
				|| violation.getPropertyPath().toString().equals("email")
				|| violation.getPropertyPath().toString().equals("username")));
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
	void shouldNotValidateTitleNull() {
		Comments comment = new Comments();
		comment.setTitle(null);
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
	void shouldNotValidateContentNull() {
		Comments comment = new Comments();
		comment.setTitle("koaoa");
		comment.setContent(null);

		Validator validator = createValidator();
		Set<ConstraintViolation<Comments>> constraintViolations = validator.validate(comment);
		assertThat(constraintViolations.size()).isEqualTo(1);
		ConstraintViolation<Comments> violation = constraintViolations.iterator().next();
		assertThat(violation.getPropertyPath().toString()).isEqualTo("content");
	}

	@Test
	void shouldValidateCommentWithAllParameters() {
		Comments comment = new Comments();
		comment.setTitle("koaoa");
		comment.setContent("Content");

		Validator validator = createValidator();
		Set<ConstraintViolation<Comments>> constraintViolations = validator.validate(comment);
		assertThat(constraintViolations.size()).isEqualTo(0);
	}

	@Test
	void shouldValidateCreditCardWithAllParameters() {
		CreditCard creditCard = new CreditCard();
		creditCard.setHolderName("Abraham");
		creditCard.setNumber(343049239);
		creditCard.setExpirationMonth(7);
		creditCard.setExpirationYear(2022);
		creditCard.setCVV(527);

		Validator validator = createValidator();
		Set<ConstraintViolation<CreditCard>> constraintViolations = validator.validate(creditCard);
		assertThat(constraintViolations.size()).isEqualTo(0);
	}

	@Test
	void shouldNotValidateHolderNameNull() {
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
	void shouldNotValidateHolderNameEmpty() {
		CreditCard creditCard = new CreditCard();
		creditCard.setNumber(343049239);
		creditCard.setExpirationMonth(7);
		creditCard.setExpirationYear(2022);
		creditCard.setCVV(527);
		creditCard.setHolderName("");

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

	@Test
	void shouldNotValidateCategotyWithNullTitle() {
		Category category = new Category();

		Validator validator = createValidator();
		Set<ConstraintViolation<Category>> constraintViolations = validator.validate(category);
		assertThat(constraintViolations.size()).isEqualTo(1);
		ConstraintViolation<Category> violation = constraintViolations.iterator().next();
		assertThat(violation.getPropertyPath().toString()).isEqualTo("title");
	}

	@Test
	void shouldNotValidateCategotyWithEmptyTitle() {
		Category category = new Category();
		category.setTitle("");
		Validator validator = createValidator();
		Set<ConstraintViolation<Category>> constraintViolations = validator.validate(category);
		assertThat(constraintViolations.size()).isEqualTo(1);
		ConstraintViolation<Category> violation = constraintViolations.iterator().next();
		assertThat(violation.getPropertyPath().toString()).isEqualTo("title");
	}

	@Test
	void shouldValidateCategotyWithAllParametersOk() {
		Category category = new Category();
		category.setTitle("Title 1");
		category.setDescription("Description 1");

		Validator validator = createValidator();
		Set<ConstraintViolation<Category>> constraintViolations = validator.validate(category);
		assertThat(constraintViolations.size()).isEqualTo(0);
	}

}