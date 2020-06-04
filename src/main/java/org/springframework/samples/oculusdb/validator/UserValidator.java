package org.springframework.samples.oculusdb.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.oculusdb.model.User;
import org.springframework.samples.oculusdb.services.UserServiceImpl;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {

	@Autowired
	private UserServiceImpl userServiceImpl;

	@Override
	public boolean supports(Class<?> aClass) {
		return User.class.equals(aClass);
	}

	@Override
	public void validate(Object o, Errors errors) {
		User user = (User) o;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
		if (user.getUsername().length() < 4 || user.getUsername().length() > 32) {
			errors.rejectValue("username", "Size.userForm.username");
		}

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty");

		if (userServiceImpl.findByUsername(user.getUsername()) != null) {
			errors.rejectValue("username", "Duplicate.userForm.username");
		}

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
		if (user.getPassword().length() < 8 || user.getPassword().length() > 32) {
			errors.rejectValue("password", "Size.userForm.password");
		}

		if (!user.getGetPasswordConfirm().equals(user.getPassword())) {
			errors.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm");
		}

	}

}
