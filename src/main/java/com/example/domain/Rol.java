/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author LuisRodríguez
 */
@Entity
@Table(name = "Rol")
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class
//        , property = "id")
public class Rol implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    @Column(name ="descripcion",nullable = false)
    private String descripcion;
    
    @ManyToMany(mappedBy = "personaRol", targetEntity = Persona.class)
    //@JsonManagedReference
    @JsonIgnoreProperties("personaRol")
    //@JsonBackReference
    //@JsonIgnore
    //@JsonManagedReference("personaRol")
    private Set<Persona> personaRol = new HashSet<>();

    public Rol() {
    }

    public Rol(Integer id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Set<Persona> getPersonaRol() {
        return personaRol;
    }

    public void setPersonaRol(Set<Persona> personaRol) {
        this.personaRol = personaRol;
    }
    
}
