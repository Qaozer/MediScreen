package com.example.mediScreen.models;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "patients")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    private String family;

    @NotNull
    private String phone;

    @NotNull
    private String address;

    @NotNull
    @Column(name = "dob")
    private Date dateOfBirth;

    @NotNull
    private String sex;

    @NotNull
    private String given;

    public Patient(){
    }

    public Patient(String family, String phone, String address, Date dateOfBirth, String sex, String given) {
        this.family = family;
        this.phone = phone;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
        this.given = given;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getGiven() {
        return given;
    }

    public void setGiven(String given) {
        this.given = given;
    }
}
