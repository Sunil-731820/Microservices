package com.example.EmployeeManagementSystemUsingAPIGateWay;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table
public class Employee {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Long id;
    

    @NotBlank(message = "Name is Mandantory")
    @Size(min = 2 , max = 12 , message = "name Should be Greater than 2 Characters And Max Will 10 Character Long")
    private String name;
    
    @NotBlank(message = "Positio is mandantory")
    @Size(min = 2 , max = 15 , message = "Position Should be max of 15 CHaracter Longs ")
    private String position;

    // Constructors, getters, and setters
    public Employee() {}

    public Employee(String name, String position) {
        this.name = name;
        this.position = position;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
}

