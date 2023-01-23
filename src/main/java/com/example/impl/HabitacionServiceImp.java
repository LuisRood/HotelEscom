/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.impl;

import com.example.dao.HabitacionDao;
import com.example.domain.Habitacion;
import com.example.services.HabitacionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author LuisRodríguez
 */
@Service
public class HabitacionServiceImp implements HabitacionService{
    @Autowired
    private HabitacionDao habitacionDao;
    
    @Override
    public List<Habitacion> getHabitacionesDisponibles() {
        return habitacionDao.findByDisponible(1);
    }

    @Override
    public List<Habitacion> getHabitacionesNoDisponibles() {
        return habitacionDao.findByDisponible(0);
    }
    
}
