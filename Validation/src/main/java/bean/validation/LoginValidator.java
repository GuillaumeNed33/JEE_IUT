package bean.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.constraints.Pattern;
import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


public class LoginValidator implements ConstraintValidator<Login, Integer> {
    private final static int MAX_SIZE = 8;
    private final static int MIN_SIZE = 2;


    @Override
    public void initialize(final Login login) {

    }

    @Override
    public boolean isValid(final Integer value, final ConstraintValidatorContext constraintValidatorContext) {
        return (MIN_SIZE <= value && value <= MAX_SIZE);
    }


}
