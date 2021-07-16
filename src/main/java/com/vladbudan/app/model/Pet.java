package com.vladbudan.app.model;

import javax.persistence.*;

@Entity
@Table(name = "pets")
public class Pet {

    @Id @GeneratedValue
    @Column(name = "pet_id")
    private Integer id;

    @Column(name = "pet_name")
    private String name;

    @Column(name = "kind")
    private String kind;

    public Pet() {

    }

    public Pet(int id, String name, String kind) {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }
}
