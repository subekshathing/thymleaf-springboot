package com.employeemployee.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String email;
    private int age;
    private String designation;
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "dep_id")
    private Department department;

  @OneToMany(mappedBy="employee",cascade = CascadeType.ALL)
  private List<FContact> contacts;

    public List<FContact> getContacts() {
        return contacts;
    }

    public void setContacts(List<FContact> contacts) {
        this.contacts = contacts;
    }

    public Department getDepartment() {
        return department;
    }


    public void setDepartment(Department department) {
        this.department = department;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age='" + age + '\'' +
                ", designation='" + designation + '\'' +
                '}';
    }
}
