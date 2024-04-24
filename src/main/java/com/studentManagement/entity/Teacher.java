package com.studentManagement.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.Base64;

@Entity
@Table(name = "teachers")
public class Teacher {


    @Column(name = "name", nullable = false)
    private String name;

//    @Lob
//    @Column(name="image", nullable = false)
//    private Blob image;


    @Column(name = "email", unique = true)
    @Email(message = "Email should be valid and end with @gmail.com")
    private String email;

    @Id
    @Column(name="teacher_id",unique=true)
    @NotNull
    private String teacherId;

    @Column(name="class_id",unique=true)
    @NotNull
    private String classId;


    @Column(name="password")
    private String password;
    public Teacher() {

    }

    public Teacher(String name,String email, String teacherId, String classId,String password) {
        super();
        this.name = name;
        this.email = email;
        this.teacherId = teacherId;
        this.classId = classId;
        this.password=password;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

//    public Blob getImage() {
//        return image;
//    }
//
//    public void setImage(Blob image) {
//        this.image = image;
//    }
}

