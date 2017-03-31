package bdx.iut.info.persistence.constraints;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 */
public class StepValidator implements ConstraintValidator<IsStep, String> {

    @Override
    public void initialize(final IsStep isStep) {

    }

    @Override
    public boolean isValid(
            final String s,
            final ConstraintValidatorContext constraintValidatorContext) {
        return (!s.isEmpty() && s.endsWith(".")
                && Character.isUpperCase(s.charAt(0)));
    }
}
