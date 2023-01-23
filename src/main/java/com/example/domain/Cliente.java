/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author LuisRodríguez
 */
@Entity
@Table(name="Cliente")
@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class
        , property = "id"
        , scope = Cliente.class)
public class Cliente implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "idpersona",nullable = false)
    //@JsonIgnore
    //@JsonIgnoreProperties("cliente")
    @JsonBackReference
    private Persona idpersona;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente")
    @JsonIgnore
    private Set<Consumo> consumos;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente")
    @JsonIgnore
    private Set<Reservacion> reservaciones;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente")
    @JsonIgnore
    private Set<ExtraEstadia> extraEstadias;
}
