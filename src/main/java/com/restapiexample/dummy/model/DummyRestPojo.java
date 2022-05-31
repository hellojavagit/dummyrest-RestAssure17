package com.restapiexample.dummy.model;

public class DummyRestPojo{
    private String name;
    private int age;
    private int salary;
    private String id;
    private String profile_image;
    private String employee_name;
    private int employee_salary;
    private int  employee_age;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public void setProfileImage(String profile_image){
        this.profile_image = profile_image;
    }
    public void setEmployee_Name(String employee_name){
        this.employee_name=employee_name;
    }
    public void setEmployee_Salary(int  employee_salary){
        this.employee_salary= employee_salary;
    }
    public void setEmployee_Age(int  employee_age){
        this.employee_age=employee_age;
    }
}
