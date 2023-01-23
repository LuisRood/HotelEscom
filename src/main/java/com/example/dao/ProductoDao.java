/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.dao;

import com.example.domain.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author LuisRodríguez
 */
public interface ProductoDao extends JpaRepository<Producto, Integer>{
    
}
