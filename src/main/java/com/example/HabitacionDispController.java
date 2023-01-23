/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example;

import com.example.dao.HabitacionDao;
import com.example.domain.Habitacion;
import com.example.domain.TipoHabitacion;
import com.example.services.HabitacionService;
import com.example.services.TipoHabitacionService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author LuisRodríguez
 */
@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
@RequestMapping("/habitacion/status")
public class HabitacionDispController {
    @Autowired
    HabitacionService habitacionService;
    @Autowired
    TipoHabitacionService tipoHabitacionService;
    @Autowired
    HabitacionDao habitacionDao;
    @RequestMapping(value = "/disponible/",method = RequestMethod.GET)
    public List<Habitacion> listHabitacionesDisp(){
        return habitacionService.getHabitacionesDisponibles();
    }
    @RequestMapping(value = "/no-disponible/",method = RequestMethod.GET)
    public List<Habitacion> listHabitacionNoDisp(){
        return habitacionService.getHabitacionesNoDisponibles();
    }
    @RequestMapping(value = "/disponible/{id}",method = RequestMethod.GET)
    public Optional<Habitacion> listHabitacionDispCliente(@PathVariable("id") int id){
        Optional<TipoHabitacion> tipoHabitacion = tipoHabitacionService.getHabitacion(id);
        return habitacionDao.findByDisponibleAndIdtipo(1, tipoHabitacion.get());
    }
}

