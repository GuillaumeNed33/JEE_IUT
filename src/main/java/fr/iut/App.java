package fr.iut;
import javax.validation.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Set;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        System.out.println( "Hello World!" );
    }
}
