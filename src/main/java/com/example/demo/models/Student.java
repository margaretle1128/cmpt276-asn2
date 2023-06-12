package com.example.demo.models;

import jakarta.persistence.*;

@Entity
@Table(name="Student")
public class Student {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int uid;
    private String name;
    private double weight;
    private double height;
    private String hairColor;
    private double gpa;
    public Student() {
    }
    public Student(String name, double weight, double height, double gpa, String hairColor) {
        this.name = name;
        this.weight = weight;
        this.height = height;
        this.hairColor = hairColor;
        this.gpa = gpa;
    }
    public int getUid() {
        return uid;
    }
    public void setUid(int uid) {
        this.uid = uid;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getWeight() {
        return weight;
    }
    public void setWeight(double d) {
        this.weight = d;
    }
    public double getHeight() {
        return height;
    }
    public void setHeight(double d) {
        this.height = d;
    }
    public String getHairColor() {
        return hairColor;
    }
    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }
    public double getGpa() {
        return gpa;
    }
    public void setGpa(double gpa) {
        this.gpa = gpa;
    }
    
}
