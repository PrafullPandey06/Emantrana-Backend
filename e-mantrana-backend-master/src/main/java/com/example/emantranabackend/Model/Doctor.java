package com.example.emantranabackend.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "doctor")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "fname",nullable = false)
    private String fname;
    @Column(name = "lname",nullable = true)
    private String lname;
    @Column(name = "password",nullable = false)
    private String password;
    @Column(name = "type",nullable = false)
    private String type;
    @Column(name = "email",nullable = false,unique = true)
    private String email;
    @Column(name = "ph_number",nullable = false)
    private String ph_number;
    @Column(name = "patient_count",nullable = false)
    private int patient_count;
    @OneToMany(mappedBy = "doctor",cascade = { CascadeType.REMOVE })
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<TimeTable> timeTable=new ArrayList<>();

    public Doctor() {
    }

    public Doctor(
                  @JsonProperty("fname")String fname,
                  @JsonProperty("lname")String lname,
                  @JsonProperty("password")String password,
                  @JsonProperty("type")String type,
                  @JsonProperty("email")String email,
                  @JsonProperty("ph_number")String ph_number,
                  @JsonProperty("patient_count")int patient_count) {

        this.fname = fname;
        this.lname = lname;
        this.password = password;
        this.type = type;
        this.email = email;
        this.ph_number = ph_number;
        this.patient_count = patient_count;

    }

    public Doctor(int id, String fname, String lname, String password, String type, String email, String ph_number, int patient_count, List<TimeTable> timeTable) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.password = password;
        this.type = type;
        this.email = email;
        this.ph_number = ph_number;
        this.patient_count = patient_count;
        this.timeTable = timeTable;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public List<TimeTable> getTimeTable() {
        return timeTable;
    }

    public void setTimeTable(List<TimeTable> timeTable) {
        this.timeTable = timeTable;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPh_number() {
        return ph_number;
    }

    public void setPh_number(String ph_number) {
        this.ph_number = ph_number;
    }

    public int getPatient_count() {
        return patient_count;
    }

    public void setPatient_count(int patient_count) {
        this.patient_count = patient_count;
    }


}
