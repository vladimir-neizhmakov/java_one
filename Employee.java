package ru.geekbrains.java_one.lesson_4;

public class Employee {
    private String surname;
    private float salary;
    private int age;
    private String position;
    private int objId;

    public Employee(){
        this.surname = "не задано";
        this.salary = 0f;
        this.age = 0;
        this.position = "не задано";
    }

    public Employee(String surname, float salary, int age, String position){
        this();
        this.objId = this.hashCode();
        this.surname = surname;
        this.salary = salary;
        this.age = age;
        this.position = position;
    }

    public String getSurname(){
        return this.surname;
    }

    public float getSalary(){
        return this.salary;
    }

    public int getAge(){
        return this.age;
    }

    public int getObjId(){
        return this.objId;
    }

    public String getPosition(){
        return this.position;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }
}
