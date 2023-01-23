/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.services;

import com.example.domain.Habitacion;
import java.util.List;

/**
 *
 * @author LuisRodríguez
 */
public interface HabitacionService {
    public List<Habitacion> getHabitacionesDisponibles();
    public List<Habitacion> getHabitacionesNoDisponibles();
}
