package com.omnidata.app2.Models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
public class Organisation {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String specialty;

    public Organisation(String name, String specialty) {
        this.name = name;
        this.specialty = specialty;
    }
}
