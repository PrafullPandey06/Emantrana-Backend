package com.example.emantranabackend.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Table(name = "time_table")
public class TimeTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "day",nullable = false)
    private String day;
    @Column(name = "Time_in",nullable = false)
    private java.sql.Time time_in;
    @Column(name = "Time_out",nullable = false)
    private java.sql.Time time_out;
    @ManyToOne()
    private Doctor doctor;

    public TimeTable() {
    }


    public TimeTable(String day, Time time_in, Time time_out, Doctor doctor) {
        this.day = day;
        this.time_in = time_in;
        this.time_out = time_out;
        this.doctor = doctor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public Time getTime_in() {
        return time_in;
    }

    public void setTime_in(Time time_in) {
        this.time_in = time_in;
    }

    public Time getTime_out() {
        return time_out;
    }

    public void setTime_out(Time time_out) {
        this.time_out = time_out;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
}
