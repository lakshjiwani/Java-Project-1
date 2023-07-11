package com.company.Users;

import com.company.database.*;

public class Staff extends Person{

    private int salary;
    private int designation;

    public Staff(String name, String password, int age, String email, int phoneNumber, String details, int salary, int designation) {
        super(name, password, age, email, phoneNumber, details);
        this.salary = salary;
        this.designation = designation;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    public void setDesignation(int designation) {
        this.designation = designation;
    }

    public int getDesignation() {
        return designation;
    }

    public void insert(String name, String password, int salary, int designation) {
        Db_Operations.insert("INSERT INTO staff (name , password, salary, designation) VALUES " +
                "(" + "'" + name + "'" + "," + "'" + password + "'" + "," + "'" + salary + "'" + "," + "'" + designation + "'" + ") ");
    }

}
