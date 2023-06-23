package com.employeemployee.model;

import jakarta.persistence.*;

@Entity
public class FContact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int phone;
    @ManyToOne()
    @JoinColumn(name="emp_id")
    private Employee employee;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", phone=" + phone +
//                ", employee=" + employee +
                '}';
    }

    public void setEmployeeId(long id) {

    }
}
