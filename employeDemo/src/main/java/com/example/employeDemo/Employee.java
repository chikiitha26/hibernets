package com.example.employeDemo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Employee {

    @Id
    private int employeeId;
    private String employeeName;
    private String dep;
    private float salary;
    private String joiningDate;

    public Employee() {
    }

    public Employee(int employeeId, String employeeName, String dep,
                    float salary, String joiningDate) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.dep = dep;
        this.salary = salary;
        this.joiningDate = joiningDate;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getDep() {
        return dep;
    }

    public void setDep(String dep) {
        this.dep = dep;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public String getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(String joiningDate) {
        this.joiningDate = joiningDate;
    }
}