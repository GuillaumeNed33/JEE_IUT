package bean;

/**
 * Created by Thomas on 04/02/2017.
 */
public class Person {
    String email;
    String firstName;
    String lastName;
    String login;
    boolean isStudent;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public boolean isStudent() {
        return isStudent;
    }

    public void setStudent(boolean student) {
        isStudent = student;
    }

    public Person(String email, String firstName, String lastName, String login, boolean isStudent) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.isStudent = isStudent;
    }
}
