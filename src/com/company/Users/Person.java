package com.company.Users;

public abstract class Person {

    private String name;
    private String password;
    private int age;
    private String email;
    private int phoneNumber;
    private String details;

    public Person(String name, String password, int age, String email, int phoneNumber, String details) {
        setName(name);
        setPassword(password);
        setAge(age);
        setEmail(email);
        setNumber(phoneNumber);
        setDetails(details);
    }

    public Person(){

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public int getNumber() {
        return phoneNumber;
    }

    public String getDetails() {
        return details;
    }
}
