package bean.validation;

/**
 * Created by gnedelec001 on 06/02/17.
 */
import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = LoginValidator.class)
public @interface Login {
    String message() default "Taille non respectée.";
    Class<?>[] groups() default {}; // Groupe de validation partiel
    Class<? extends Payload>[] payload() default{}; // Metadonnée de la contrainte
}
