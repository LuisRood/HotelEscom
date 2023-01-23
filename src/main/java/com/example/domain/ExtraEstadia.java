/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;

/**
 *
 * @author LuisRodríguez
 */
@Entity
@Table(name ="Extra_estadia")
@Data
@JsonIdentityInfo(
  generator = ObjectIdGenerators.PropertyGenerator.class, 
  property = "id")
public class ExtraEstadia implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "cantidad",nullable = false)
    private Integer cantidad;
    @ManyToOne
    @JoinColumn(name = "id_cliente",referencedColumnName = "id")
    private Cliente cliente;

    
}
