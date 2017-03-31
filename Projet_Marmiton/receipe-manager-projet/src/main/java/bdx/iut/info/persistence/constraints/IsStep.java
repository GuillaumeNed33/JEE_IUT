package bdx.iut.info.persistence.constraints;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = {StepValidator.class})
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(value = RetentionPolicy.RUNTIME)
public @interface IsStep {
    String message() default "Invalid Step";

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}