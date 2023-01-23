/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author LuisRodríguez
 */
@Entity
@Table(name ="Habitacion")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class
        , property = "id"
        , scope = Habitacion.class)
public class Habitacion implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "limpia",nullable = false)
    private Integer limpia;
    @Column(name = "disponible",nullable = false)
    private Integer disponible;
    @OneToOne
    @JoinColumn(name="id_tipo",referencedColumnName ="id")
    private TipoHabitacion idtipo;

    @ManyToMany(mappedBy = "contieneHabitaciones", targetEntity = Reservacion.class)
    @JsonIgnoreProperties("contieneHabitaciones")
    private Set<Reservacion> contieneHabitaciones = new HashSet<>();
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLimpia() {
        return limpia;
    }

    public void setLimpia(Integer limpia) {
        this.limpia = limpia;
    }

    public Integer getDisponible() {
        return disponible;
    }

    public void setDisponible(Integer disponible) {
        this.disponible = disponible;
    }

    public TipoHabitacion getIdtipo() {
        return idtipo;
    }

    public void setIdtipo(TipoHabitacion idtipo) {
        this.idtipo = idtipo;
    }

    public Set<Reservacion> getReservacion() {
        return contieneHabitaciones;
    }

    public void setReservacion(Set<Reservacion> contieneHabitaciones) {
        this.contieneHabitaciones = contieneHabitaciones;
    }
     
}
