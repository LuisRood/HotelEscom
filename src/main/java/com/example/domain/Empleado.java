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
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Time;
import java.util.Set;
import javax.persistence.*;

/**
 *
 * @author LuisRodríguez
 */
@Entity
@Table(name = "Empleado")
@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class
        , property = "id"
        , scope = Empleado.class)
public class Empleado implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "hora_entrada",nullable = false)
    private Time hora_entrada;
    @Column(name = "hora_salida",nullable = false)
    private Time hora_salida;
    @Column(name = "salario",nullable = false)
    BigDecimal salario;
    @Column(name = "departamento",nullable = false)
    String departamento;
    
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "idpersona",nullable = false)
    //@JsonIgnoreProperties("empleado")
    //@JsonIgnore
    @JsonBackReference
    private Persona idpersona;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado")
    @JsonIgnore
    private Set<Reservacion> reservaciones;
}
