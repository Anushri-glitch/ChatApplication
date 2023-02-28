package com.Shrishti.chatApplication.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Entity
@Table(name="table_User")
@Data
public class User {
    @Id
    @Column(name="username")
    private String Username;
    @Column(name="password")
    private String Password;
    @Column(name="firstname")
    private String firstName;
    @Column(name="lastname")
    private String lastName;
    @Column(name="email")
    private String Email;
    @Column(name="phone")
    private String phoneNumber;
    @Column(name="age")
    private Integer age;
    @Column(name="gender")
    private String Gender;
    @Column(name="CreatedDate")
    private Timestamp createdDate;
    @Column(name="UpdatedDate")
    private Timestamp updatedDate;
    @Column(name="status")
    private Boolean Status;
    @ManyToOne
    @JoinColumn(name="StatusId")
    private Status statusId;
}
