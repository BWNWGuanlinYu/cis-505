package application;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Student {
    private final StringProperty firstName = new SimpleStringProperty();
    private final StringProperty lastName = new SimpleStringProperty();
    private final StringProperty course = new SimpleStringProperty();
    private final StringProperty grade = new SimpleStringProperty();

    public Student(String firstName, String lastName, String course, String grade) {
        setFirstName(firstName);
        setLastName(lastName);
        setCourse(course);
        setGrade(grade);
    }

    // Getter and setter methods for properties

    public String getFirstName() {
        return firstName.get();
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public StringProperty firstNameProperty() {
        return firstName;
    }

    public String getLastName() {
        return lastName.get();
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public StringProperty lastNameProperty() {
        return lastName;
    }

    public String getCourse() {
        return course.get();
    }

    public void setCourse(String course) {
        this.course.set(course);
    }

    public StringProperty courseProperty() {
        return course;
    }

    public String getGrade() {
        return grade.get();
    }

    public void setGrade(String grade) {
        this.grade.set(grade);
    }

    public StringProperty gradeProperty() {
        return grade;
    }
}
