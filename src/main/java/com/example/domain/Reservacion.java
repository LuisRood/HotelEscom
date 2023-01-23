/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author LuisRodríguez
 */
@Entity
@Table(name = "Reservacion")
@Data
@JsonIdentityInfo(
  generator = ObjectIdGenerators.PropertyGenerator.class, 
  property = "id",
  scope = Reservacion.class)
public class Reservacion implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reservacion")
    private Integer id;
    @Column(name ="acompañantes",nullable = false)
    private Integer acompaniantes;
    @Column(name ="habitaciones",nullable = false)
    private Integer habitaciones;
    @Column(name ="fecha_inicial",nullable = false)
    private Date fechainicial;
    @Column(name ="fecha_final",nullable = false)
    private Date fechafinal;

    
    @ManyToOne
    @JoinColumn(name = "id_cliente",referencedColumnName = "id")
    @JsonBackReference
    private Cliente cliente;
    @ManyToOne
    @JoinColumn(name = "id_empleado",referencedColumnName = "id")
    @JsonBackReference
    private Empleado empleado;
    
    @ManyToMany( fetch = FetchType.EAGER, targetEntity = Habitacion.class)
    @JoinTable(name = "Contiene_habitaciones",
            joinColumns = { @JoinColumn(name = "id_reservacion") },
            inverseJoinColumns = { @JoinColumn(name = "id_habitacion") })
        @JsonIgnoreProperties("contieneHabitaciones")
    private Set<Habitacion> contieneHabitaciones = new HashSet<>();
}
