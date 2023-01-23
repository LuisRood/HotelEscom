/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.dao;

import com.example.domain.Habitacion;
import com.example.domain.TipoHabitacion;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author LuisRodríguez
 */
public interface HabitacionDao extends JpaRepository<Habitacion, Integer>{
    public List<Habitacion> findByDisponible(Integer disponible);
    public Optional<Habitacion> findByDisponibleAndIdtipo(Integer disponible,TipoHabitacion tipoHabitacion);
}
