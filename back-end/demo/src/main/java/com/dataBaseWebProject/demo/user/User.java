package com.dataBaseWebProject.demo.user;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue

    public int Id;
    public String name;
    public String email;
    public String password;

}
