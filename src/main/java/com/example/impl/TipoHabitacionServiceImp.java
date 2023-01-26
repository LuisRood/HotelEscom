/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.impl;

import com.example.dao.TipoHabitacionDao;
import com.example.domain.TipoHabitacion;
import com.example.services.TipoHabitacionService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author LuisRodríguez
 */
@Service
public class TipoHabitacionServiceImp implements TipoHabitacionService{
    @Autowired
    private TipoHabitacionDao tipoHabitacionDao;

    @Override
    public Optional<TipoHabitacion> getHabitacion(Integer id) {
        return tipoHabitacionDao.findById(id);
    }

    @Override
    public List<TipoHabitacion> getHabitaciones() {
        return tipoHabitacionDao.findAll();
    }

    @Override
    public TipoHabitacion saveHabitacion(TipoHabitacion tipoHabitacion) {
        return tipoHabitacionDao.save(tipoHabitacion);
    }
}
