/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example;

import com.example.domain.TipoHabitacion;
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
@RequestMapping("/habitacion")
public class HabitacionController {
    @Autowired
    private TipoHabitacionService tipoHabitacionService;
    
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public List<TipoHabitacion> listHabitaciones(){
        return tipoHabitacionService.getHabitaciones();
    }
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Optional<TipoHabitacion> getHabitacion(@PathVariable("id")int id){
        return tipoHabitacionService.getHabitacion(id);
    }
}
