package fr.iut;

import bean.Person;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

public class App 
{
    public static void main( String[] args )
    {

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Person p1 = new Person();
        p1.setLogin("");



    }
}
