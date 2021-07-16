package com.vladbudan.app.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id @GeneratedValue
    @Column(name = "user_id")
    private Integer id;

    @Column(name = "user_name")
    private String username;

    public User() {

    }

    public User(int id, String name) {
        this.id = id;
        this.username = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
