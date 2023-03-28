package com.example.managementanimals.entity;

import jakarta.persistence.*;

@Entity
@Table(name="animals")
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",  nullable = false, unique = true, length = 5)
    private int id;

    @Column (name = "name", nullable = false, length = 50)
    private String name;

    @Column (name = "image")
    private String image;
    @Column (name = "description")
    private String description;
    @Column (name = "specie", length = 50)
    private String specie;

    public Animal() {}

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSpecie() {
        return specie;
    }

    public void setSpecie(String specie) {
        this.specie = specie;
    }
}
