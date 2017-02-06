package bean;

/**
 * Created by gnedelec001 on 06/02/17.
 */
import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import javax.xml.validation.Validator;
import java.util.Set;

import static org.junit.Assert.assertEquals;


public class LoginTest {
    private  static Validator validator;
    private Set<ConstraintViolation<Person>> violations;

    @BeforeClass
    public static void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    }

    @Test
    public void testNOk() {
        Person p2 = new Person();
        p2.setFirstName("21");
        p2.setLastName("a");
        p2.setEmail("21");
        p2.setLogin(null);
       // violations = validator.validate(p2.getLogin());
        assertEquals(4, violations.size());
    }
}
