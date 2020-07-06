package com.homepro.me.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@JsonIgnoreProperties(value = { "employees" })
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "position")
    private String position;

    @Column(name = "department")
    private String department;

    // @Column(name = "companyBrance")
    // private String companyBrance;

    @Column(name = "salary")
    private int salary;

    public Employee() {
    }

    public Employee(int id, String name, String position, String department, int salary) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.department = department;
        // this.companyBrance = companyBrance;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    // public String getCompanyBrance() {
    // return companyBrance;
    // }

    // public void setCompanyBrance(String companyBrance) {
    // this.companyBrance = companyBrance;
    // }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", name='" + name + '\'' + ", position='" + position + '\'' + ", department="
                + department + '\'' + ", salary=" + salary + "}";
    }
}
