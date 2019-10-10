package edu.tam.sample.forms;

import java.time.LocalDate;

public class WorkerForm {
    private String id;
    private String name;
    private String occupation;
    private int salary;
    private String Speciality;
    private String employmentDay;

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

    public String getSpeciality() {
        return Speciality;
    }

    public void setSpeciality(String speciality) {
        Speciality = speciality;
    }

    public String getEmploymentDay() {
        return employmentDay;
    }

    public void setEmploymentDay(String employmentDay) {
        this.employmentDay = employmentDay;
    }

    @Override
    public String toString() {
        return "WorkerForm{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", occupation='" + occupation + '\'' +
                ", salary=" + salary +
                ", Speciality='" + Speciality + '\'' +
                ", employmentDay='" + employmentDay + '\'' +
                '}';
    }
}
