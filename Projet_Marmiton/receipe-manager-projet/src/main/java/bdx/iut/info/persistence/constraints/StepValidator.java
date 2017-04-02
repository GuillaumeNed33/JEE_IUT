package bdx.iut.info.persistence.constraints;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**.
 * IsStepValidator Implementation
 */
public class StepValidator implements ConstraintValidator<IsStep, String> {
    /**.
     * initialisation
     * @param isStep .
     */
    @Override
    public void initialize(final IsStep isStep) {

    }

    /**.
     * Condition of validation
     * @param s .
     * @param constraintValidatorContext .
     * @return boolean
     */
    @Override
    public boolean isValid(
            final String s,
            final ConstraintValidatorContext constraintValidatorContext) {
        return (!s.isEmpty() && s.endsWith(".")
                && Character.isUpperCase(s.charAt(0)));
    }
}
