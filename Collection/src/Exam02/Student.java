package Exam02;

import java.time.LocalDate;

public class Student {
    private String code;
    private String firstName;
    private String lastName;
    private String gender;
    private LocalDate dateOfBirth;
    private String course;
    public Student() {
    }
    public Student(String code, String firstName, String lastName, String gender, LocalDate dateOfBirth,
            String course) {
        this.code = code;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.course = course;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
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
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    public String getCourse() {
        return course;
    }
    public void setCourse(String course) {
        this.course = course;
    }
    @Override
    public String toString() {
        return "Student [code=" + code + ", firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender
                + ", dateOfBirth=" + dateOfBirth + ", course=" + course + "]";
    }
    
}
