package com.example.emantranabackend.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity
@Table(name = "admin")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "email",nullable = false,unique = true)
    private String userId;
    @Column(name = "password",nullable = false)
    private String password;
    @Column(name = "roles",nullable = false)
    private String roles;

    public Admin() {

    }

    public Admin(int id,
                 @JsonProperty("userId")String userId,
                 @JsonProperty("password")String password, String roles) {
        this.id = id;
        this.userId = userId;
        this.password = password;
        this.roles = roles;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

