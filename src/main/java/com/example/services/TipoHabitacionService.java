/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.services;

import com.example.domain.TipoHabitacion;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author LuisRodríguez
 */
public interface TipoHabitacionService {
    public Optional<TipoHabitacion> getHabitacion(Integer id);
    public List<TipoHabitacion> getHabitaciones();
    public TipoHabitacion saveHabitacion(TipoHabitacion tipoHabitacion);
}
