package com.site.StickyBoard;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordsMatchValidator implements ConstraintValidator<PasswordsMatch, Object> {
	
	@Override
	public void initialize(PasswordsMatch constraintAnnotation) {
		
	}
	
	@Override
	public boolean isValid(Object object, ConstraintValidatorContext context) {
		SiteUserDTO userDTO = (SiteUserDTO) object;
		return userDTO.getRegisterPassword().equals(userDTO.getRegisterConfirmPassword());
	}

}
