package edu.tam.sample.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Document
public class Worker {

    @Id
    private String id;
    private String name;
    private String occupation;
    private int salary;
    private Speciality speciality;
    private LocalDateTime employmentDay;

    public Worker() {
    }

    public Worker(String name, String occupation, int salary, Speciality speciality, LocalDateTime employmentDay) {
        this.name = name;
        this.occupation = occupation;
        this.salary = salary;
        this.speciality = speciality;
        this.employmentDay = employmentDay;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }

    public LocalDateTime getEmploymentDay() {
        return employmentDay;
    }

    public void setEmploymentDay(LocalDateTime employmentDay) {
        this.employmentDay = employmentDay;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", occupation='" + occupation + '\'' +
                ", salary=" + salary +
                ", speciality=" + speciality +
                ", employmentDay=" + employmentDay +
                '}';
    }
}
