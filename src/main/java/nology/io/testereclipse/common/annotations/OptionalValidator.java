package nology.io.testereclipse.common.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class OptionalValidator implements ConstraintValidator<IsOptional, Object> {

	@Override
	public void initialize(IsOptional constraintAnnotation) {

	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		return value == null;
	}

}
