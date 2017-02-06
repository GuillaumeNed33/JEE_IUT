package bean;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Thomas on 04/02/2017.
 */
public class Project {
    String description;
    @NotNull
    String name;
    @NotNull
    String urlRepository;
    List<Person> teachers;
    List<Person> students;
    List<Person> customers;
    List<Document> myDocuments;

    public Project(String description, String name, String urlRepository) {
        this.description = description;
        this.name = name;
        this.urlRepository = urlRepository;
    }

    public List<Person> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Person> teachers) {
        this.teachers = teachers;
    }

    public List<Person> getStudents() {
        return students;
    }

    public void setStudents(List<Person> students) {
        this.students = students;
    }

    public List<Person> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Person> customers) {
        this.customers = customers;
    }

    public List<Document> getMyDocuments() {
        return myDocuments;
    }

    public void setMyDocuments(List<Document> myDocuments) {
        this.myDocuments = myDocuments;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrlRepository() {
        return urlRepository;
    }

    public void setUrlRepository(String urlRepository) {
        this.urlRepository = urlRepository;
    }

}
